package com.example.TestSQLQuery.Repository;

import com.example.TestSQLQuery.Entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PagingRepositoryJpa extends PagingAndSortingRepository<Employee, Long> {
}
