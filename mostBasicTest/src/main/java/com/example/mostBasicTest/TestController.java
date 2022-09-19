package com.example.mostBasicTest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Value("${abc}")
    private String abc;


    @GetMapping("/test")
    String testController (@RequestBody List<SingleDto> singleDtoList){
        return abc;
    }
}
