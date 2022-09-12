package com.example.AmigoMongoSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class TestController {
  @Autowired private StudentRepository studentRepository;
  @Autowired private TestInsertRepository testInsertRepository;
  @Autowired private MongoTemplate mongoTemplate;

  @GetMapping("/test-docker")
  String  testDocker() {
    return "test docker";
  }

  @GetMapping("/insert-test")
  void testInsert() {
    Student student = buildStudent();
    studentRepository.save(student);
  }

  @GetMapping("/test-find")
  void findStudent(@RequestParam String email) {
    findStudentMethod(email);
  }

  private void findStudentMethod(String email) {
    Query query = new Query();
    query.addCriteria(Criteria.where("email").is(email));
    List<Student> studentList = mongoTemplate.find(query, Student.class);

    List<Student> studentList1 = studentRepository.findStudentByLastName("nguyen");
    Student student = studentRepository.findStudentByFirstName("huong").get();

    List<Student> studentList2 = studentRepository.findStudentsByLastName("huong");
  }

  private Student buildStudent() {
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

  @GetMapping("/test-insert-update")
  void testInsertUpdate() {
    //cannot auto generate long type id so must specify id
    TestInsert testInsert = TestInsert.builder().id(1L).name("test insert 1").build();
    testInsertRepository.save(testInsert);


    // only difference when perform save a Document with specified ID


    Student student = new Student();
    student.setId("abc");
    student.setFirstName("first insert specified id");
    studentRepository.insert(student);
    // this will throw error duplicated
//    student.setFirstName("second insert specified id");
//    studentRepository.insert(student);

    // this will perform update
    student.setFirstName("second insert specified id");
    studentRepository.save(student);



  }
}
