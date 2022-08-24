package com.example.TestSQLQuery;

import com.example.TestSQLQuery.Entity.Employee;
import com.example.TestSQLQuery.MappingObject.InterfaceMappingDtos;
import com.example.TestSQLQuery.MappingObject.ResultSetDto;
import com.example.TestSQLQuery.Repository.EmployeeRepository;
import com.example.TestSQLQuery.Repository.GeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
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

    /**
     * Using interface mapping to prove that generic type in repository is used to map the result
     * to the specified entity
     *
     * if using customize mapping then can use any type for generic type, put that query in any repo
     *
     * */
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

    /**
     * NATIVE QUERY
     */

    /**
     * two ways to map result:
     * interface Result Mapping refer to InterfaceMappingDtos
     * @SqlResultMapping refer to Employee
     * /

    /**
    three ways to perform native query: @Query(native = true), @NamedNativeQuery, EntityManager
     *
     * */


    @GetMapping("/native-query-named-result-mapping")
    void nativeQueryNamedNativeQuery(){
        List<ResultSetDto> resultSetDtos = employeeRepository.namedNativeQueryResultMapping();
    }

    @GetMapping("/native-query-em-result-mapping")
    void nativeQueryEm(){
        List<ResultSetDto> resultSetDtos = employeeRepository.getAllEmailNativeEm();
    }

}
