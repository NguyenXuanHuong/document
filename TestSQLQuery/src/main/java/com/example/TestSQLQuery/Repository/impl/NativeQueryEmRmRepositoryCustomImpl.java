package com.example.TestSQLQuery.Repository.impl;

import com.example.TestSQLQuery.MappingObject.ResultSetDto;
import com.example.TestSQLQuery.Repository.NativeQueryEmRmRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NativeQueryEmRmRepositoryCustomImpl implements NativeQueryEmRmRepositoryCustom {

    @Autowired
    EntityManager em;
    @Override
    public List<ResultSetDto> getAllEmailNativeEm() {

        Map<String, String> params = new HashMap<>();
        List<ResultSetDto> result = new ArrayList<>();
        String sql = "select em.e_name as ename, em.dob as dob from employee as em where id < :id";


        Query query = em.createNativeQuery(sql, "nativeQueryEm") ;
        query.setParameter("id", 4);
        for (Object obj : query.getResultList() ) {
            result.add((ResultSetDto) obj);
        }
        return result;
    }
}
