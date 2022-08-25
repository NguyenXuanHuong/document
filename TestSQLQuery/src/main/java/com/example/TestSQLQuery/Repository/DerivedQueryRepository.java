package com.example.TestSQLQuery.Repository;

import com.example.TestSQLQuery.Entity.DerivedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DerivedQueryRepository extends JpaRepository<DerivedEntity, Long> {

  // lowerCase is still correct
  DerivedEntity findByDerivedEntityName(String name);

  DerivedEntity findByderivedEntityName(String name);

  // if query return > 2 result => error
  // DerivedEntity findByStringAttr(String str);
  // Equality
  List<DerivedEntity> findByStringAttr(String str); // => should use this

  List<DerivedEntity> findByLongAttrIs(Long l);

  List<DerivedEntity> findByLongAttrEquals(Long l); // same as Is

  List<DerivedEntity> findByLongAttrIsNot(Long l);

  List<DerivedEntity> findByLongAttrIsNull();

  List<DerivedEntity> findByLongAttrIsNotNull();

  List<DerivedEntity> findByBooleanAttrTrue();

  List<DerivedEntity> findByBooleanAttrFalse();

  // SIMILAR
  List<DerivedEntity> findByStringAttrStartingWith(String prefix);

  List<DerivedEntity> findByStringAttrEndingWith(String suffix);

  List<DerivedEntity> findByStringAttrContaining(String str);
  // Containing abc str = "abcd" containing "bc"
  // Like str = "Abcd" like "a%b%c", like need pattern
  List<DerivedEntity> findByStringAttrLike(String pattern);

  // COMPARING
  List<DerivedEntity> findByLongAttrGreaterThan(Long l);

  List<DerivedEntity> findByLongAttrLessThan(Long l);

  List<DerivedEntity> findByLongAttrGreaterThanEqual(Long l);

  List<DerivedEntity> findByLongAttrBetween(Integer start, Integer end);

  List<DerivedEntity> findByLongAttrIn(List<Integer> list);

  List<DerivedEntity> findByDobAfter(LocalDate localDate);

  List<DerivedEntity> findByDobBefore(LocalDate localDate);

  // SORT (SORT AND PAGING IS DIFFERENT)
  List<DerivedEntity> findByDobBeforeOrderByDobAsc(LocalDate localDate);

  List<DerivedEntity> findByDobBeforeOrderByDobDesc(LocalDate localDate);
}
