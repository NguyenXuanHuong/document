package com.example.UdemyGrpc.server;

import com.example.models.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@GrpcService
public class BankService extends BankServiceGrpc.BankServiceImplBase {
  @Autowired
  BankServiceGrpc.BankServiceStub bankServiceStub;

  @Autowired
  BankServiceGrpc.BankServiceBlockingStub blockingStub;
  @Override
  public void getBalance(BalanceCheckRequest request, StreamObserver<Balance> responseObserver) {
    int accountNumber = request.getAccountNumber();
    Balance balance = Balance.newBuilder().setBalance(accountNumber * 10).build();
    responseObserver.onNext(balance);
    responseObserver.onCompleted();
  }

  @Override
  public void serverStream(WithdrawRequest request, StreamObserver<Money> responseObserver) {
    Money money = Money.newBuilder().setAmount(100).build();
    for (int i = 0; i < 4; i++) {
      responseObserver.onNext(money);
      //
    }
    if (request.getAmount() > 100){
        Status status = Status.FAILED_PRECONDITION.withDescription("amount too much");
        responseObserver.onError(status.asRuntimeException());
    }
    responseObserver.onCompleted();
  }

  @Override
  public StreamObserver<Money> clientStream(
          StreamObserver<MoneyBack> responseObserver){
    List<Money> list = new ArrayList<>();
    StreamObserver<Money> streamObserver = new StreamObserver<Money>() {
      @Override
      public void onNext(Money money) {
        System.out.println("+++++++++++onNext++++++++++"+ money.getAmount());
        list.add(money);
      }

      @Override
      public void onError(Throwable throwable) {
        System.out.println(throwable.getMessage());
      }

      @Override
      public void onCompleted() {
        System.out.println("+++++++++++++client send complete++++++++++++++");
        MoneyBack moneyBack = MoneyBack.newBuilder().setAmount(100).build();
        responseObserver.onNext(moneyBack);
      }
    };
    return streamObserver;


  }

  @Override
  public StreamObserver<Money> biDiStream(
          StreamObserver<MoneyBack> responseObserver) {
    return new StreamObserver<Money>() {
      @Override
      public void onNext(Money money) {
        System.out.println("hihi");
      }

      @Override
      public void onError(Throwable throwable) {

        System.out.println("dm vl");
      }

      @Override
      public void onCompleted() {

        List<MoneyBack> list =
            List.of(
                MoneyBack.newBuilder().setAmount(100).build(),
                MoneyBack.newBuilder().setAmount(200).build());
        list.forEach(responseObserver::onNext);
        responseObserver.onCompleted();
        System.out.println("++++++++++++++completed");
      }
    };
  }
}
