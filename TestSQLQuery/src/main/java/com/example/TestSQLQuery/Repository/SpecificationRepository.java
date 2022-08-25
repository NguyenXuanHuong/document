package com.example.TestSQLQuery.Repository;

import com.example.TestSQLQuery.Entity.Employee;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface SpecificationRepository extends CrudRepository<Employee, Long>, JpaSpecificationExecutor<Employee> {
}
