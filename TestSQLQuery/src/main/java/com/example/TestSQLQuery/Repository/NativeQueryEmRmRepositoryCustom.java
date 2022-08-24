package com.example.TestSQLQuery.Repository;

import com.example.TestSQLQuery.MappingObject.ResultSetDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NativeQueryEmRmRepositoryCustom {
    List<ResultSetDto> getAllEmailNativeEm();
    Page<ResultSetDto> pagingTest(Pageable pageable);

}
