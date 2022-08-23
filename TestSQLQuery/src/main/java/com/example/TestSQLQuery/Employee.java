package com.example.TestSQLQuery;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeSequenceForEmployee")
    @SequenceGenerator(name = "employeeSequenceForEmployee", sequenceName = "hibernate_sequence")
    private Long id;
    private String eName;
    private LocalDateTime DoB;

}
