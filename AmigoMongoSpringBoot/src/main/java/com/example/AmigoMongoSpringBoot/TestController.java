package com.example.AmigoMongoSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class TestController {
  @Autowired private StudentRepository studentRepository;

  @GetMapping("/insert-test")
  void testInsert() {
    Student student = buildStudent();
    studentRepository.save(student);
  }

  private Student buildStudent(){
      Student student = new Student();
      Address address = new Address("vn", "12345", "hn");
      student.setAddress(address);
      student.setFirstName("huong");
      student.setLastName("nguyen");
      student.setEmail("abc");
      student.setGender(Gender.MALE);
      student.setFavoriteSubjects(List.of("java", "springboot"));
      student.setTotalSpentInBooks(new BigDecimal(1));
      student.setCreatedAt(LocalDateTime.now());
      return student;
  }
}
