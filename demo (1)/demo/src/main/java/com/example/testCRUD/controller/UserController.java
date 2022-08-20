package com.example.testCRUD.controller;

import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/abc")
public class UserController {

  @GetMapping("")
  public void getAllUsers(HttpServletRequest httpServletRequest){
    httpServletRequest.getClass();
  }
}
