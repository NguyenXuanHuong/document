package com.example.TestSQLQuery.Entity;

import com.example.TestSQLQuery.MappingObject.JpqlMappingDto;
import com.example.TestSQLQuery.MappingObject.ResultSetDto;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.LocalDate;

@Entity

//cannot use with jpql
//@NamedQuery(
//        name = "GeneralEntity.jpqlTest", //entityName.methodName in Repo
//        query = "select e.eName as EName2, e.eName as EName1, e.DoB as Dob from Employee as e where e.eName = :ename",
//        resultSetMapping = "jpqlTest")

@SqlResultSetMappings({

        @SqlResultSetMapping(
                name = "jpqlTest",
                classes =
                @ConstructorResult(
                        targetClass = JpqlMappingDto.class,
                        columns = {
                                @ColumnResult(name = "EName", type = String.class), // name of as XXX in select sql
                                @ColumnResult(name = "Dob", type = LocalDate.class)
                        }))


})
public class GeneralEntity {
    @Id
    private String id;

}
