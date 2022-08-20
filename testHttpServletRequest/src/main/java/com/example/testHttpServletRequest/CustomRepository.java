package com.example.testHttpServletRequest;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CustomRepository {

    @PersistenceContext
    private EntityManager entityManager;



}
