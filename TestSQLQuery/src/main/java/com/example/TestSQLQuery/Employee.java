package com.example.TestSQLQuery;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NamedNativeQuery(
    name = "Employee.findAllResultSetMapping",
    query = "select  * from employee",
    resultSetMapping = "resultSetMappingEmployee")
@SqlResultSetMapping(
    name = "resultSetMappingEmployee",
    classes =
        @ConstructorResult(
            targetClass = ResultSetDto.class,
            columns = {
              @ColumnResult(name = "e_name", type = String.class),
              @ColumnResult(name = "dob", type = LocalDate.class)
            }))
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeSequenceForEmployee")
    @SequenceGenerator(name = "employeeSequenceForEmployee", sequenceName = "hibernate_sequence")
    private Long id;
    private String eName;
    private LocalDate DoB;

}
