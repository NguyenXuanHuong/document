package com.example.TestSQLQuery.Repository;

import com.example.TestSQLQuery.Entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PagingRepositoryJpa extends PagingAndSortingRepository<Employee, Long> {

    Page<Employee> findByeName(String ename, Pageable pageable);
}
