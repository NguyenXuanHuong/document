package com.example.TestSQLQuery.CriteriaQuery.Repository.Impl;

import com.example.TestSQLQuery.CriteriaQuery.DtoMapping.AggregationResultDto;
import com.example.TestSQLQuery.CriteriaQuery.DtoMapping.MultipleRootDto;
import com.example.TestSQLQuery.CriteriaQuery.Repository.CQRepositoryCustom;
import com.example.TestSQLQuery.CriteriaQuery.DtoMapping.ResultDtoMapping;
import com.example.TestSQLQuery.Entity.Employee;
import com.example.TestSQLQuery.Entity.EmployeeOneToMany;
import com.example.TestSQLQuery.Entity.EmployeeOneToMany_;
import com.example.TestSQLQuery.Entity.Employee_;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class CQRepositoryCustomImpl implements CQRepositoryCustom {

  @PersistenceContext EntityManager entityManager;

  @Override
  public void whereCriteria() {

    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Employee> cq = cb.createQuery(Employee.class); // return type is Employee
    Root<Employee> root = cq.from(Employee.class);
    //
    cq.select(root);
    //
    Predicate p1 = cb.equal(root.get(Employee_.E_NAME), "e1");
    cq.where(p1);
    //
    Query query = entityManager.createQuery(cq);
    List<Employee> list = query.getResultList();
  }

  @Override
  public void selectEntityAttr() {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<LocalDate> cq = cb.createQuery(LocalDate.class); // return type is Employee
    Root<Employee> root = cq.from(Employee.class);
    //
    cq.select(root.get(Employee_.DO_B));
    //
    Predicate p1 = cb.equal(root.get(Employee_.E_NAME), "e1");
    cq.where(p1);
    //
    Query query = entityManager.createQuery(cq);
    List<LocalDate> list = query.getResultList();
  }

  @Override
  public void selectMultipleAttrObjectArray() {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class); // return type is Employee
    Root<Employee> root = cq.from(Employee.class);
    //
    Path<String> path1 = root.get(Employee_.E_NAME);
    Path<LocalDate> path2 = root.get(Employee_.DO_B);
    Path<Long> path3 = root.get(Employee_.ID);
    //        cq.select(cb.array(path1, path2,path3)); => first way
    cq.multiselect(path1, path2, path3);
    //
    Predicate p1 = cb.equal(root.get(Employee_.E_NAME), "e1");
    cq.where(p1);
    Query query = entityManager.createQuery(cq);
    List<Object[]> list = query.getResultList();
    for (Object[] objects : list) {
      String ename = (String) objects[0];
      Long id = (Long) objects[2];
      LocalDate localDate = (LocalDate) objects[1];
    }
  }

  @Override
  public void selectMultipleAttrDtoMapping() {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<ResultDtoMapping> cq =
        cb.createQuery(ResultDtoMapping.class); // return type is Employee
    Root<Employee> root = cq.from(Employee.class);
    //
    Path<String> pathEname = root.get(Employee_.E_NAME);
    Path<LocalDate> pathDob = root.get(Employee_.DO_B);
    Path<Long> pathId = root.get(Employee_.ID);
    //        cq.select(cb.array(path1, path2,path3)); => first way
    cq.select(cb.construct(ResultDtoMapping.class, pathId, pathEname, pathDob));
    //
    Predicate p1 = cb.equal(root.get(Employee_.E_NAME), "e1");
    cq.where(p1);
    Query query = entityManager.createQuery(cq);
    List<ResultDtoMapping> list = query.getResultList();
    for (ResultDtoMapping resultDtoMapping : list) {
      String ename = resultDtoMapping.getEName();
      Long id = resultDtoMapping.getId();
      LocalDate localDate = resultDtoMapping.getDob();
    }
  }

  @Override
  public void selectMultipleAttrTuple() {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Tuple> cq = cb.createQuery(Tuple.class); // return type is Employee
    Root<Employee> root = cq.from(Employee.class);
    //
    Path<String> pathEname = root.get(Employee_.E_NAME);
    Path<LocalDate> pathDob = root.get(Employee_.DO_B);
    Path<Long> pathId = root.get(Employee_.ID);
    //        cq.select(cb.array(path1, path2,path3)); => first way
    cq.multiselect(pathDob, pathId, pathEname);
    //
    Predicate p1 = cb.equal(root.get(Employee_.E_NAME), "e1");
    cq.where(p1);
    //
    Query query = entityManager.createQuery(cq);
    List<Tuple> list = query.getResultList();
    for (Tuple result : list) {
      String ename = result.get(pathEname);
      Long id = result.get(pathId);
      LocalDate localDate = result.get(pathDob);
    }
  }

  @Override
  public void selectMultipleAttrByMultipleRoot() {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<MultipleRootDto> cq =
        cb.createQuery(MultipleRootDto.class); // return type is Employee
    // multiple Root
    Root<Employee> emRoot = cq.from(Employee.class);
    Root<EmployeeOneToMany> emOTMRoot = cq.from(EmployeeOneToMany.class);
    //
    Path<String> pathEname = emRoot.get(Employee_.E_NAME);
    Path<LocalDate> pathIdForRef = emOTMRoot.get(EmployeeOneToMany_.ID_FOR_REF);
    cq.select(cb.construct(MultipleRootDto.class, pathEname, pathIdForRef));
    //
    Predicate pEm = cb.equal(emRoot.get(Employee_.E_NAME), "e1");
    Predicate pEmOTM = cb.equal(emOTMRoot.get(EmployeeOneToMany_.NAME), "r1");
    cq.where(cb.and(pEm, pEmOTM));
    //
    Query query = entityManager.createQuery(cq);
    List<MultipleRootDto> list = query.getResultList();
    for (MultipleRootDto result : list) {
      String ename = result.getEname();
      Long id = result.getIdForRef();
    }
  }

    @Override
    public void join() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<MultipleRootDto> cq =
                cb.createQuery(MultipleRootDto.class); // return type is Employee
        // multiple Root
        Root<Employee> emRoot = cq.from(Employee.class);
        Join<Employee, EmployeeOneToMany> eOTMRoot= emRoot.join(Employee_.EMPLOYEE_ONE_TO_MANY, JoinType.LEFT);
        //
        Path<String> pathEname = emRoot.get(Employee_.E_NAME);
        Path<Long> pathIdForRef = eOTMRoot.get(EmployeeOneToMany_.ID_FOR_REF);
        cq.select(cb.construct(MultipleRootDto.class, pathEname, pathIdForRef));
        //
        Predicate pEm = cb.equal(emRoot.get(Employee_.E_NAME), "e1");
        Predicate pEmOTM = cb.equal(eOTMRoot.get(EmployeeOneToMany_.NAME), "r1");
        cq.where(cb.and(pEm, pEmOTM));
        //
        Query query = entityManager.createQuery(cq);
        List<MultipleRootDto> list = query.getResultList();
        for (MultipleRootDto result : list) {
            String ename = result.getEname();
            Long id = result.getIdForRef();
        }
    }

  @Override
  public void param() {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<MultipleRootDto> cq =
            cb.createQuery(MultipleRootDto.class); // return type is Employee
    // multiple Root
    Root<Employee> emRoot = cq.from(Employee.class);
    Join<Employee, EmployeeOneToMany> eOTMRoot= emRoot.join(Employee_.EMPLOYEE_ONE_TO_MANY, JoinType.LEFT);
    ParameterExpression<String> enameParam = cb.parameter(String.class);
    ParameterExpression<String> idRefParam = cb.parameter(String.class);
    //
    Path<String> pathEname = emRoot.get(Employee_.E_NAME);
    Path<Long> pathIdForRef = eOTMRoot.get(EmployeeOneToMany_.ID_FOR_REF);
    cq.select(cb.construct(MultipleRootDto.class, pathEname, pathIdForRef));
    //
    Predicate pEm = cb.equal(emRoot.get(Employee_.E_NAME), enameParam);
    Predicate pEmOTM = cb.equal(eOTMRoot.get(EmployeeOneToMany_.NAME), idRefParam);
    cq.where(cb.and(pEm, pEmOTM));
    //
    Query query = entityManager.createQuery(cq);
    query.setParameter(enameParam, "e1");
    query.setParameter(idRefParam, "r1");


    List<MultipleRootDto> list = query.getResultList();
    for (MultipleRootDto result : list) {
      String ename = result.getEname();
      Long id = result.getIdForRef();
    }
  }

  @Override
  public void aggregationFunc() {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<AggregationResultDto> cq =
            cb.createQuery(AggregationResultDto.class);
    Root<Employee> emRoot = cq.from(Employee.class);
    //
    Path<Long> pathId = emRoot.get(Employee_.ID);
    Expression<Long> countDistinctExpress = cb.countDistinct(pathId);
    Expression<Long> countExpress = cb.count(pathId);
    Expression<Long> sumIdExpress = cb.sum(pathId);
    Expression<Double> avgExpress = cb.avg(pathId);
    Expression<Long> maxExpress = cb.max(pathId);
    // aggregate
    cq.select(
        cb.construct(
            AggregationResultDto.class,
            countDistinctExpress,
            countExpress,
            sumIdExpress,
            maxExpress, avgExpress));
    //
    Query query = entityManager.createQuery(cq);
    AggregationResultDto countResult= (AggregationResultDto) query.getSingleResult();

  }

  @Override
  public void groupByHavingOrderBy() {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<AggregationResultDto> cq =
            cb.createQuery(AggregationResultDto.class);
    Root<Employee> emRoot = cq.from(Employee.class);
    //
    Path<Long> pathId = emRoot.get(Employee_.ID);
    // aggregation
    Expression<Long> countDistinctExpress = cb.countDistinct(pathId);
    Expression<Long> countExpress = cb.count(pathId);
    Expression<Long> sumIdExpress = cb.sum(pathId);
    Expression<Double> avgExpress = cb.avg(pathId);
    Expression<Long> maxExpress = cb.max(pathId);
    //
    cq.select(
            cb.construct(
                    AggregationResultDto.class,
                    countDistinctExpress,
                    countExpress,
                    sumIdExpress,
                    maxExpress, avgExpress));
    Path<LocalDate> localDatePath = emRoot.get(Employee_.DO_B);
    Predicate datePredicate = cb.greaterThanOrEqualTo(localDatePath, LocalDate.of(2022, Month.AUGUST, 10));
    cq.groupBy(localDatePath);
    cq.having(datePredicate);
    Path<String> pathEname = emRoot.get(Employee_.E_NAME);
    Order order = cb.asc(pathEname);
    cq.orderBy(order);

            //
    Query query = entityManager.createQuery(cq);
    List<AggregationResultDto> list = query.getResultList();
  }

  @Override
  public void subQuery() {
    CriteriaBuilder cb = entityManager.getCriteriaBuilder();
    CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
    Root<Employee> emRoot = cq.from(Employee.class);
    //subquery
    Subquery<Long> subquery = cq.subquery(Long.class);
    Root<EmployeeOneToMany> subRoot = subquery.from(EmployeeOneToMany.class);
    Path<Long> idForRefPath = subRoot.get(EmployeeOneToMany_.ID_FOR_REF);
    subquery.select(idForRefPath);
    // predicate
    Path<Long> idEmployeePath = emRoot.get(Employee_.ID);
    Predicate idInPredicate = cb.in(idEmployeePath).value(subquery);
    cq.where(idInPredicate);
    //
    Query query = entityManager.createQuery(cq);
    List<Employee> list = query.getResultList();

  }
}
