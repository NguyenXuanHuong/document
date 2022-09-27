package com.example.mostBasicTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class TestController {


    @Autowired
    AwsTestS3 awsTestS3;
    @GetMapping("/test-aws")
    public void testS3(@RequestParam("test")MultipartFile multipartFile) throws IOException {
        awsTestS3.uploadFileToS3(multipartFile);
    }
}
