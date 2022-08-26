package com.example.TestSQLQuery.CriteriaQuery.Repository;

public interface CQRepositoryCustom {
    void whereCriteria();
    void selectEntityAttr();
    void selectMultipleAttrObjectArray();
    void selectMultipleAttrDtoMapping();
    void selectMultipleAttrTuple();
    void selectMultipleAttrByMultipleRoot();
    void join();
    void param();
    void aggregationFunc();
    void groupByHavingOrderBy();
    void subQuery();
}
