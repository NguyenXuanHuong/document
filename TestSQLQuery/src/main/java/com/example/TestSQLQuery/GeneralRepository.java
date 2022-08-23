package com.example.TestSQLQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GeneralRepository extends JpaRepository<GeneralEntity, String> {

    @Query(value = "select e_name from employee_name", nativeQuery = true)
    List<InterfaceMappingDtos> getAllEmployeeView();

    @Query(value = "select e_name from employee", nativeQuery = true)
    List<InterfaceMappingDtos> getEmployeeEntity();


}
