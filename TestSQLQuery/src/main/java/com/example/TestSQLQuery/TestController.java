package com.example.TestSQLQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    GeneralRepository generalRepository;

    @GetMapping("test")
    void test(){
        Employee employee = new Employee();
        employee.setName("e1");
        employee.setDoB(new );
        employeeRepository.save(employee);
        Employee employee1 = new Employee();
        employee1.setName("e2");
        employeeRepository.save(employee1);

        List<Employee> employeeList = employeeRepository.getAllEmployee();
    }
}
