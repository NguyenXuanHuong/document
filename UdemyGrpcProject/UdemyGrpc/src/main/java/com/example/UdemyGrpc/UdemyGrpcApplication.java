package com.example.UdemyGrpc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class UdemyGrpcApplication {
  public static void main(String[] args) throws InterruptedException {
//      Server server = ServerBuilder.forPort(6565).addService(new BankService())
//              .build();
//      server.start();
//      server.awaitTermination();
      SpringApplication.run(UdemyGrpcApplication.class, args);
  }
}
