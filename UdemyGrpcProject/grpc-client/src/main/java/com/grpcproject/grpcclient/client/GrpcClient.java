package com.grpcproject.grpcclient.client;

import com.example.models.*;
import io.grpc.stub.StreamObserver;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Service
public class GrpcClient {

  @Autowired private BankServiceGrpc.BankServiceBlockingStub bankServiceBlockingStub;

  @Autowired private BankServiceGrpc.BankServiceStub bankServiceStub;

  public Balance getBalance(int accountNumber) {
    BalanceCheckRequest balanceCheckRequest =
        BalanceCheckRequest.newBuilder().setAccountNumber(accountNumber).build();
    return bankServiceBlockingStub.getBalance(balanceCheckRequest);
  }

  public List<Money> withdraw(int accountNumber) throws InterruptedException {
    WithdrawRequest withdrawRequest = WithdrawRequest.newBuilder().setAmount(accountNumber).build();
    List<Money> moneyList = new ArrayList<>();
    CountDownLatch countDownLatch = new CountDownLatch(1);
    // Specify how to treat response from server
    StreamObserver<Money> streamObserver =
        new StreamObserver<>() {
          @Override
          public void onNext(Money money) {
            moneyList.add(money);
          }

          @SneakyThrows
          @Override
          public void onError(Throwable throwable) {
            throw throwable;
          }

          @Override
          public void onCompleted() {
            System.out.println("++++++++++++++++++++completed");
          }
        };
    // actual call to server
    bankServiceStub.serverStream(withdrawRequest, streamObserver);
//    bankServiceBlockingStub.serverStream(withdrawRequest);
    countDownLatch.await();
    return moneyList;

    //    bankServiceBlockingStub.serverStream(withdrawRequest);
  }

  public void clientStreaming(){
      List<Money> moneyList = new ArrayList<>();
      moneyList.add(Money.newBuilder().setAmount(100).build());
      moneyList.add(Money.newBuilder().setAmount(200).build());
      StreamObserver<MoneyBack> backStreamObserver = new StreamObserver<MoneyBack>() {
          @Override
          public void onNext(MoneyBack moneyBack) {
              System.out.println("++++++++++++++++money back: "+moneyBack.getAmount());
          }

          @Override
          public void onError(Throwable throwable) {

              System.out.println(throwable.getMessage());
          }

          @Override
          public void onCompleted() {

              System.out.println("completed");

          }
      };

      // create a stream to get Money from client and send that Money to server
      StreamObserver<Money> streamObserver = bankServiceStub.clientStream(backStreamObserver);
      moneyList.forEach(streamObserver::onNext);
      streamObserver.onCompleted();

  }

    public void biDiStream(){
        List<Money> moneyList = new ArrayList<>();
        moneyList.add(Money.newBuilder().setAmount(100).build());
        moneyList.add(Money.newBuilder().setAmount(200).build());
        moneyList.add(Money.newBuilder().setAmount(300).build());
        StreamObserver<MoneyBack> howToHandleServerResponse = new StreamObserver<>() {
            @Override
            public void onNext(MoneyBack moneyBack) {
                System.out.println("++++++++++++++++money back: "+moneyBack.getAmount());
            }

            @Override
            public void onError(Throwable throwable) {

                System.out.println(throwable.getMessage());
            }

            @Override
            public void onCompleted() {

                System.out.println("completed");

            }
        };

        // create a stream to get Money from client and send that Money to server
        StreamObserver<Money> streamObserver = bankServiceStub.biDiStream(howToHandleServerResponse);
        moneyList.forEach(streamObserver::onNext);
        streamObserver.onCompleted();

    }



}
