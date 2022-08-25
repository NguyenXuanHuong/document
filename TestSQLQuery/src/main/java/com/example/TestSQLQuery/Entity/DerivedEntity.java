package com.example.TestSQLQuery.Entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Entity
public class DerivedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceForDeriveEntity")
    @SequenceGenerator(name = "sequenceForDeriveEntity", sequenceName = "sequenceForDeriveEntity")
    private Long id;
    private String derivedEntityName;
    private LocalDate dob;
    private Long longAttr;
    private String stringAttr;
    private Boolean booleanAttr;

}
