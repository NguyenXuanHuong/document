package com.example.testHttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/test")
@InternalApi
public class ControllerTest {

    @Autowired
    private CustomRepository customRepository;

    @Autowired
    private TestRepoInterface testRepoInterface;

    @Autowired
    private TestRepoInterfaceCAR testRepoInterfaceCAR;

    @GetMapping
    public void testSave(){

//       Cars cars = testRepoInterfaceCAR.findById(1L).get();
//       String psName = cars.getPerson().getPersonName();

    }
}
