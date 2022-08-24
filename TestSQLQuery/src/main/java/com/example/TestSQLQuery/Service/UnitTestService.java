package com.example.TestSQLQuery.Service;

import com.example.TestSQLQuery.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnitTestService {
    @Autowired
    EmployeeRepository employeeRepository;

    public void testService(){
        employeeRepository.getAllEmployee();
    }
}
