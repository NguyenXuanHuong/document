package com.example.AmigoMongoSpringBoot;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestInsertRepository extends MongoRepository<TestInsert, Long> {
}
