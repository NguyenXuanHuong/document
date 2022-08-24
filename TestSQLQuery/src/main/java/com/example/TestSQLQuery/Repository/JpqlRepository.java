package com.example.TestSQLQuery.Repository;

import com.example.TestSQLQuery.Entity.GeneralEntity;
import com.example.TestSQLQuery.MappingObject.InterfaceMappingDtos;
import com.example.TestSQLQuery.MappingObject.InterfaceMappingJPQL;
import com.example.TestSQLQuery.MappingObject.JpqlMappingDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface JpqlRepository extends CrudRepository<GeneralEntity, Long> {
    @Query()
    JpqlMappingDto jpqlTest(@Param("ename") String ename);

}
