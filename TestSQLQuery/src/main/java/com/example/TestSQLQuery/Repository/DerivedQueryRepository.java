package com.example.TestSQLQuery.Repository;

import com.example.TestSQLQuery.Entity.DerivedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DerivedQueryRepository extends JpaRepository<DerivedEntity, Long> {

    DerivedEntity findByDerivedEntityName(String name);

    DerivedEntity findByderivedEntityName(String name);
}
