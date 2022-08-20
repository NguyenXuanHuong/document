package com.example.testHttpServletRequest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TestRepoInterfaceCAR extends JpaRepository<Cars, Long> {

    @Query(value = "select person.personName from Cars car join car.person person")
    String findAllCarsList();
}
