package com.example.TestSQLQuery.TestCascade;

import com.example.TestSQLQuery.Entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface CascadeTestRepository extends CrudRepository<Employee, Long> {
}
