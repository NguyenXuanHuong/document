package com.example.TestSQLQuery.CriteriaQuery.Repository;

import com.example.TestSQLQuery.CriteriaQuery.Repository.CQRepositoryCustom;
import com.example.TestSQLQuery.Entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface CQRepository extends CrudRepository<Employee, Long>, CQRepositoryCustom {
}
