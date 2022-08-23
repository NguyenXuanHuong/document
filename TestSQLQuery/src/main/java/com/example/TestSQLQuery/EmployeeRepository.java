package com.example.TestSQLQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    @Query(value = "select * from employee", nativeQuery = true)
    List<Employee> getAllEmployee();

    @Query(value = "select e_name from employee", nativeQuery = true)
    List<InterfaceMappingDtos> getAllEmployeeInterfaceMapping();

    @Query(nativeQuery = true)
    List<ResultSetDto> findAllResultSetMapping();


}
