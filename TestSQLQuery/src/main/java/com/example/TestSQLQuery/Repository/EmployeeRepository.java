package com.example.TestSQLQuery.Repository;

import com.example.TestSQLQuery.Entity.Employee;
import com.example.TestSQLQuery.MappingObject.InterfaceMappingDtos;
import com.example.TestSQLQuery.MappingObject.ResultSetDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> , NativeQueryEmRmRepositoryCustom {


    @Query(value = "select * from employee", nativeQuery = true)
    List<Employee> getAllEmployee();

    @Query(value = "select e_name,  dob as e_dob from employee", nativeQuery = true)
    List<InterfaceMappingDtos> getAllEmployeeInterfaceMapping();

    @Query(nativeQuery = true)
    List<ResultSetDto> namedNativeQueryResultMapping(); // use this method name in resultSetMapping

    Page<Employee> findByeName(String ename, Pageable pageable);

    Employee findByeName(String ename);


}
