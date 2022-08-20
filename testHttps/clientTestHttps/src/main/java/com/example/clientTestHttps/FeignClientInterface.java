package com.example.clientTestHttps;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "abc", url = "https://localhost:8081/",configuration = CustomFeignConfiguration.class)
public interface FeignClientInterface {

    @RequestMapping(method = RequestMethod.GET, value = "/get-test")
    String getTest();

}
