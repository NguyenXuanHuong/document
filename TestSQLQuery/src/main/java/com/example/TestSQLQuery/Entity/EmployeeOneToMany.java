package com.example.TestSQLQuery.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeOneToMany implements Serializable { //if refered column is not PK, must implements Serializable

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorForEmployeeOneToMany")
    @SequenceGenerator(name = "generatorForEmployeeOneToMany", sequenceName = "hibernate_sequence")
    private Long id;
    @OneToMany(mappedBy = "employeeOneToMany", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Employee> employeeList;
    private String name;
    private Long age;
    private LocalDate dob;
    private Long idForRef;
}
