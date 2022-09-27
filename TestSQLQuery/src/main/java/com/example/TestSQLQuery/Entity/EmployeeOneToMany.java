package com.example.TestSQLQuery.Entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeOneToMany implements Serializable { //if refered column is not PK, must implements Serializable

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generatorForEmployeeOneToMany")
    @SequenceGenerator(name = "generatorForEmployeeOneToMany", sequenceName = "hibernate_sequence")
    private Long id;
    @OneToMany(mappedBy = "employeeOneToMany", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Employee> employeeList;
    private String name;
    private Long age;
    private LocalDate dob;
    private Long idForRef;
}
