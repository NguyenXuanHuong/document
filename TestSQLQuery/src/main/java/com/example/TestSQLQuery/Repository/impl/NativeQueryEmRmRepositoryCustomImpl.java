package com.example.TestSQLQuery.Repository.impl;

import com.example.TestSQLQuery.MappingObject.ResultSetDto;
import com.example.TestSQLQuery.Repository.NativeQueryEmRmRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// naming of custom repository is really important so that spring boot does not auto create sql for it query
public class NativeQueryEmRmRepositoryCustomImpl implements NativeQueryEmRmRepositoryCustom {

    @Autowired
    EntityManager em;
    @Override
    public List<ResultSetDto> getAllEmailNativeEm() {

        Map<String, String> params = new HashMap<>();
        List<ResultSetDto> result = new ArrayList<>();
        String sql = "select em.e_name as ename, em.dob as dob from employee as em where id < :id";


        Query query = em.createNativeQuery(sql, "nativeQueryEm") ;
        query.setParameter("id", 9);
        for (Object obj : query.getResultList() ) {
            result.add((ResultSetDto) obj);
        }
        return result;
    }

    @Override
    public Page<ResultSetDto> pagingTest(Pageable pageable) {
        Map<String, String> params = new HashMap<>();
        List<ResultSetDto> result = new ArrayList<>();
        String sql = "select em.e_name as ename, em.dob as dob from employee as em order by :orderBy :direction";
        String countSql = "select count(*) from employee";


        Query count = em.createNativeQuery(countSql);
        Number total = (Number) count.getSingleResult();
        // get items
        Query query = em.createNativeQuery(sql, "nativeQueryEm") ;
        query.setFirstResult((int)pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());
        Sort sort = pageable.getSort();
        Sort.Order order = sort.stream().findFirst().orElse(null);
        String property = order.getProperty();
        String direction = order.getDirection().name();
        query.setParameter("orderBy", property);
        query.setParameter("direction", direction);
        for (Object obj : query.getResultList() ) {
            result.add((ResultSetDto) obj);
        }
        return new PageImpl<>(result, pageable, total.intValue());
    }
}
