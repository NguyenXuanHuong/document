package com.example.TestSQLQuery.Entity;

import com.example.TestSQLQuery.Entity.EmployeeOneToMany_;
import com.example.TestSQLQuery.MappingObject.ResultSetDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Data
@NamedNativeQuery(
    name = "Employee.namedNativeQueryResultMapping", //entityName.methodName in Repo
    query = "select  * from employee",
    resultSetMapping = "resultSetMappingNamedQuery")

@SqlResultSetMappings({

        // using named query
        @SqlResultSetMapping(
                name = "resultSetMappingNamedQuery",
                classes =
                @ConstructorResult(
                        targetClass = ResultSetDto.class,
                        columns = {
                                @ColumnResult(name = "e_name", type = String.class), // name of column in table
                                @ColumnResult(name = "dob", type = LocalDate.class)
                        })),


        // using entity manager
        @SqlResultSetMapping(
                name = "nativeQueryEm",
                classes =
                @ConstructorResult(
                        targetClass = ResultSetDto.class,
                        columns = {
                                @ColumnResult(name = "ename", type = String.class), // name of as XXX in select sql
                                @ColumnResult(name = "dob", type = LocalDate.class)
                        }))


})

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeSequenceForEmployee")
    @SequenceGenerator(name = "employeeSequenceForEmployee", sequenceName = "hibernate_sequence") // if hibernate_sequence1 not exist => create new sequence
    private Long id;
    private String eName;
    private LocalDate DoB;

    private String another;

  @ManyToOne(cascade = CascadeType.PERSIST) // SHOULD NOT USE ALL HERE
  @JoinColumn(
      name = "employee_one_to_many_id_name",
      referencedColumnName = EmployeeOneToMany_.ID_FOR_REF
      ) // which column in referenced table
  private EmployeeOneToMany employeeOneToMany;
}
