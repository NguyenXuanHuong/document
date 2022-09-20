package com.example.UdemyGrpc.server;


import com.example.models.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class BankService extends BankServiceGrpc.BankServiceImplBase {
    @Override
    public void getBalance(BalanceCheckRequest request,
                           StreamObserver<Balance> responseObserver) {
       int accountNumber = request.getAccountNumber();
       Balance balance = Balance.newBuilder().setBalance(accountNumber*10).build();
       responseObserver.onNext(balance);
       responseObserver.onCompleted();
    }
    @Override
    public void withDraw(WithDrawMoneyRequest request,
                         StreamObserver<Money> responseObserver){
        int amount = request.getAmount();
        if (amount > 1000){
            Status status = Status.FAILED_PRECONDITION.withDescription("too much");
            responseObserver.onError(status.asRuntimeException());
            return;
        }
        int balance = 400;

        /**
         * before call onCompleted => server still send request and client wait for completed*/
        for (int i = 0; i < 4 ; i++) {
            Money money = Money.newBuilder().setAmount(100).build();
            responseObserver.onNext(money);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException interruptedException){
                Status status = Status.FAILED_PRECONDITION.withDescription("internal exception");
                responseObserver.onError(status.asRuntimeException());
                return;
            }

        }
        responseObserver.onCompleted();

    }
}
