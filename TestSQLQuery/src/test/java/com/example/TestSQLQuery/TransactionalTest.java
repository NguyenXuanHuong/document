package com.example.TestSQLQuery;

import com.example.TestSQLQuery.Entity.Employee;
import com.example.TestSQLQuery.Repository.EmployeeRepository;
import com.example.TestSQLQuery.Service.UnitTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.*;
import static org.junit.Assert.*;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class TransactionalTest {
    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    private UnitTestService unitTestService;

    @Test
    public void test(){
    Mockito.when(employeeRepository.getAllEmployee()).thenThrow(new RuntimeException());
    RuntimeException thrown = assertThrows(
            RuntimeException.class,
            ()->unitTestService.testService()
    );
    assertEquals("Abc", thrown.getMessage());


    }

    @Test
    public void test2(){
        Mockito.when(employeeRepository.getAllEmployee()).thenReturn(List.of());
        assertEquals("cde", unitTestService.testService());
    }





}
