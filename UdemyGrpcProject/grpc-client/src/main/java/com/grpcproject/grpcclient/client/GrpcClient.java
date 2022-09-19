package com.grpcproject.grpcclient.client;

import com.example.models.Balance;
import com.example.models.BalanceCheckRequest;
import com.example.models.BankServiceGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrpcClient {

    @Autowired
    private BankServiceGrpc.BankServiceBlockingStub bankServiceBlockingStub;

    public Balance getBalance(int accountNumber){
        BalanceCheckRequest balanceCheckRequest = BalanceCheckRequest.newBuilder().setAccountNumber(accountNumber).build();
        return bankServiceBlockingStub.getBalance(balanceCheckRequest);
    }


}
