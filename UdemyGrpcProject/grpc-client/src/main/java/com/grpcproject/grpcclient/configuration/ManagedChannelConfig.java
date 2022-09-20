package com.grpcproject.grpcclient.configuration;

import com.example.models.BankServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManagedChannelConfig {
    @Bean
    ManagedChannel managedChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();
    }

    @Bean
    BankServiceGrpc.BankServiceBlockingStub bankServiceBlockingStub() {
        return BankServiceGrpc.newBlockingStub(managedChannel());
    }

    @Bean
    BankServiceGrpc.BankServiceStub bankServiceStub() {
        return BankServiceGrpc.newStub(managedChannel());
    }
}
