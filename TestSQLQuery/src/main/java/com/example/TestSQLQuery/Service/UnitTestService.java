package com.example.TestSQLQuery.Service;

import com.example.TestSQLQuery.Repository.EmployeeRepository;
import org.hibernate.jpamodelgen.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitTestService {

    @Autowired
    MockService mockService;
    @Autowired
    MockService2 mockService2;



    public String testService(){

        //
        String abc = "Abc";
//        String s = mockService.mockMethod(abc) + mockService2.mockMethod2(abc);
//        String s = mockService2.mockMethod2(abc);
//        return abc;
        return mockService.mockMethod(abc,"cde");
    }
}
