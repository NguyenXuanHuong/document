package com.example.TestSQLQuery.Repository;

import com.example.TestSQLQuery.MappingObject.ResultSetDto;

import java.util.List;

public interface NativeQueryEmRmRepositoryCustom {
    List<ResultSetDto> getAllEmailNativeEm();
}
