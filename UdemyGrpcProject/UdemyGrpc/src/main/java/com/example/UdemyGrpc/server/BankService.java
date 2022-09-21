package com.example.UdemyGrpc.server;


import com.example.models.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.ArrayList;
import java.util.List;

import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

@GrpcService
public class BankService extends BankServiceGrpc.BankServiceImplBase {
    @Override
    public void getBalance(BalanceCheckRequest request,
                           StreamObserver<Balance> responseObserver) {
        int accountNumber = request.getAccountNumber();
        Balance balance = Balance.newBuilder().setBalance(accountNumber * 10).build();
        responseObserver.onNext(balance);
        responseObserver.onCompleted();
    }

    @Override
    public void withDraw(WithDrawMoneyRequest request,
                         StreamObserver<Money> responseObserver) {
        int amount = request.getAmount();
        if (amount > 1000) {
            Status status = Status.FAILED_PRECONDITION.withDescription("too much");
            responseObserver.onError(status.asRuntimeException());
            return;
        }
        int balance = 400;

        /**
         * before call onCompleted => server still send request and client wait for completed*/
        for (int i = 0; i < 4; i++) {
            Money money = Money.newBuilder().setAmount(100).build();
            responseObserver.onNext(money);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                Status status = Status.FAILED_PRECONDITION.withDescription("internal exception");
                responseObserver.onError(status.asRuntimeException());
                return;
            }

        }
        responseObserver.onCompleted();

    }


    @Override
    public StreamObserver<Money> clientStream(
            StreamObserver<MoneyBack> responseObserver) {

        // how to treat request from client
        return new StreamObserver<Money>() {
            MoneyBack moneyBack;
            @Override
            public void onNext(Money money) {
                moneyBack = MoneyBack.newBuilder().setAmount(1880).build();
                // cannot noNext multiple times
//                responseObserver.onNext(moneyBack);
            }

            @Override
            public void onError(Throwable throwable) {

                System.out.println(throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onNext(moneyBack);
                responseObserver.onCompleted();
            }
        };
    }


    public StreamObserver<Money> biDiStream(
           StreamObserver<MoneyBack> responseObserver) {
        return new StreamObserver<Money>() {
            @Override
            public void onNext(Money money) {
                responseObserver.onNext(MoneyBack.newBuilder().setAmount(190).build());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("dm vl");
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }


}
