package com.grpcproject.grpcclient;

import com.grpcproject.grpcclient.client.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerClass {

    @Autowired
    GrpcClient grpcClient;

    @GetMapping("/test")
    void test() throws InterruptedException {
        grpcClient.getBalance(10);
        grpcClient.withdraw(100);
    }


}
