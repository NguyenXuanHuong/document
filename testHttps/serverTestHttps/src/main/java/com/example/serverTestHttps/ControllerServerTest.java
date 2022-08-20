package com.example.serverTestHttps;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/get-test")
public class ControllerServerTest {

    @GetMapping()
    public String getTestServer(){
        return "Abc";
    }
}
