package com.example.TestSQLQuery.Repository.impl;

import com.example.TestSQLQuery.Entity.EmployeeOneToMany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OneToManyRepository extends JpaRepository<EmployeeOneToMany, Long> {
}
