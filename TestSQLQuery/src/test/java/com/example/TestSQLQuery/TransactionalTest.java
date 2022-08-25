package com.example.TestSQLQuery;

import com.example.TestSQLQuery.Entity.Employee;
import com.example.TestSQLQuery.Repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TransactionalTest {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EntityManager em;
    @Test
    void test(){
//        Employee employee = em.find(Employee.class, 1l);
//        Long iD = employee.getId();
//        employeeRepository.getAllEmailNativeEm();
    }

}
