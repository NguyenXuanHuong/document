package com.example.UdemyGrpc.server;


import com.example.models.Balance;
import com.example.models.BalanceCheckRequest;
import com.example.models.BankServiceGrpc;
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
}
