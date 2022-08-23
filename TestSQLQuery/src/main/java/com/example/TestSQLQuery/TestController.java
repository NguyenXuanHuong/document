package com.example.TestSQLQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TestController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    GeneralRepository generalRepository;

    @GetMapping("test")
    void test(){
        Employee employee = new Employee();
        employee.setEName("e1");
        employee.setDoB(LocalDate.of(2022, Month.AUGUST, 22));
        employeeRepository.save(employee);
        Employee employee1 = new Employee();
        employee1.setEName("e2");
        employee1.setDoB(LocalDate.of(2022, Month.AUGUST, 28));
        employeeRepository.save(employee1);

        List<Employee> employeeList = employeeRepository.getAllEmployee();
    }

    @GetMapping("/interface-mapping")
    public void interfaceMappingTest(){

        // if using interface mapping, can place query in any repository no matter Entity
        List<InterfaceMappingDtos> interfaceMappingDtos = employeeRepository.getAllEmployeeInterfaceMapping();
        List<String> emailList = interfaceMappingDtos.stream().map(InterfaceMappingDtos::gete_name).collect(Collectors.toList());

        List<InterfaceMappingDtos> interfaceMappingDtos1 = generalRepository.getAllEmployeeView();
        List<String> emailList1 = interfaceMappingDtos1.stream().map(InterfaceMappingDtos::gete_name).collect(Collectors.toList());

        List<InterfaceMappingDtos> interfaceMappingDtos2 = generalRepository.getEmployeeEntity();
        List<String> emailList2 = interfaceMappingDtos2.stream().map(InterfaceMappingDtos::gete_name).collect(Collectors.toList());

    }

    @GetMapping("/test-result-set-mapping")
    void testResultSetMapping(){
        List<ResultSetDto> resultSetDtos = employeeRepository.findAllResultSetMapping();
    }
}
