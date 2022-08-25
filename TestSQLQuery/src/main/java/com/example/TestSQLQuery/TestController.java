package com.example.TestSQLQuery;

import com.example.TestSQLQuery.Entity.Employee;
import com.example.TestSQLQuery.Entity.Employee_;
import com.example.TestSQLQuery.MappingObject.InterfaceMappingDtos;
import com.example.TestSQLQuery.MappingObject.InterfaceMappingJPQL;
import com.example.TestSQLQuery.MappingObject.JpqlMappingDto;
import com.example.TestSQLQuery.MappingObject.ResultSetDto;
import com.example.TestSQLQuery.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TestController {
  @Autowired EmployeeRepository employeeRepository;

  @Autowired GeneralRepository generalRepository;

  @Autowired JpqlRepository jpqlRepository;

  @Autowired SpecificationRepository specificationRepository;

  @GetMapping("test")
  void test() {
    Employee employee = new Employee();
    employee.setEName("e1");
    employee.setDoB(LocalDate.of(2022, Month.AUGUST, 22));
    employeeRepository.save(employee);
    Employee employee1 = new Employee();
    employee1.setEName("e2");
    employee1.setDoB(LocalDate.of(2022, Month.AUGUST, 28));
    employeeRepository.save(employee1);

    List<Employee> employeeList = employeeRepository.getAllEmployee();
  }

  /**
   * Using interface mapping to prove that generic type in repository is used to map the result to
   * the specified entity
   *
   * <p>if using customize mapping then can use any type for generic type, put that query in any
   * repo
   */
  @GetMapping("/interface-mapping")
  public void interfaceMappingTest() {

    // if using interface mapping, can place query in any repository no matter Entity
    List<InterfaceMappingDtos> interfaceMappingDtos =
        employeeRepository.getAllEmployeeInterfaceMapping();
    List<String> emailList =
        interfaceMappingDtos.stream()
            .map(InterfaceMappingDtos::gete_name)
            .collect(Collectors.toList());

    List<InterfaceMappingDtos> interfaceMappingDtos1 =
        employeeRepository.getAllEmployeeInterfaceMapping();
    List<LocalDate> dobList =
        interfaceMappingDtos.stream()
            .map(InterfaceMappingDtos::gete_dob)
            .collect(Collectors.toList());

    //        List<InterfaceMappingDtos> interfaceMappingDtos1 =
    // generalRepository.getAllEmployeeView();
    //        List<String> emailList1 =
    // interfaceMappingDtos1.stream().map(InterfaceMappingDtos::gete_name).collect(Collectors.toList());

    List<InterfaceMappingDtos> interfaceMappingDtos2 = generalRepository.getEmployeeEntity();
    List<String> emailList2 =
        interfaceMappingDtos2.stream()
            .map(InterfaceMappingDtos::gete_name)
            .collect(Collectors.toList());
  }

  /** NATIVE QUERY */

  /**
   * two ways to map result: interface Result Mapping refer to
   * InterfaceMappingDtos @SqlResultMapping refer to Employee /
   *
   * <p>/** three ways to perform native query: @Query(native = true), @NamedNativeQuery,
   * EntityManager
   */
  @GetMapping("/native-query-named-result-mapping")
  void nativeQueryNamedNativeQuery() {
    List<ResultSetDto> resultSetDtos = employeeRepository.namedNativeQueryResultMapping();
  }

  @GetMapping("/native-query-em-result-mapping")
  void nativeQueryEm() {
    List<ResultSetDto> resultSetDtos = employeeRepository.getAllEmailNativeEm();
  }

  @GetMapping("/native-query-pagable")
  Page<ResultSetDto> nativeQueryPagable(
      @PageableDefault(page = 0, size = 3)
          @SortDefault.SortDefaults({@SortDefault(sort = "ename", direction = Sort.Direction.DESC)})
          Pageable pageable) {
    Sort.Order orderEname = new Sort.Order(Sort.Direction.ASC, Employee_.E_NAME);
    Sort.Order orderDob = new Sort.Order(Sort.Direction.DESC, Employee_.DO_B);
    List<Sort.Order> orders = new ArrayList<>(List.of(orderEname, orderDob));
    Sort sort = Sort.by(orders);
    Pageable pageable1 = PageRequest.of(0, 10, sort);
    return employeeRepository.pagingTest(pageable1);
  }

  @GetMapping("/jpql")
  void testJpql() {
    JpqlMappingDto jpqlMappingDto = jpqlRepository.jpqlTest("e1");
    String ename = jpqlMappingDto.getEname();
    LocalDate dob = jpqlMappingDto.getDob();
  }

  @GetMapping("/specification")
  void testSpec() {

    // https://www.youtube.com/watch?v=jygBsfE1K1s&ab_channel=LumaBIT
    // project structure turn target to source
    Specification<Employee> specification =
        (root, query, builder) -> builder.equal(root.get(Employee_.E_NAME), "e1");
    Specification<Employee> andSpec =
        (root, query, builder) ->
            builder.greaterThan(root.<LocalDate>get(Employee_.DO_B), LocalDate.of(2021, 12, 12));
    specificationRepository.findAll(specification.and(andSpec));
  }

  @Autowired
  PagingRepositoryJpa pagingRepositoryJpa;
  @GetMapping("/paging-jpa")
  Page<Employee> testPagingJpa() {
    return pagingRepositoryJpa.findByeName("e1", PageRequest.of(0, 10, Sort.by(new Sort.Order(Sort.Direction.DESC, Employee_.E_NAME))));
  }
  @Autowired
  DerivedQueryRepository derivedQueryRepository;
  @GetMapping("/derived-query")
  void testDerivedQuery(){
    derivedQueryRepository.findByderivedEntityName("d1");
    derivedQueryRepository.findByderivedEntityName("d1");
    derivedQueryRepository.findByStringAttr("a");
    derivedQueryRepository.findByLongAttrLessThan(1l);
  }
}
