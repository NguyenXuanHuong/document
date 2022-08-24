package com.example.TestSQLQuery.Entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GeneralEntity {
    @Id
    private String id;

}
