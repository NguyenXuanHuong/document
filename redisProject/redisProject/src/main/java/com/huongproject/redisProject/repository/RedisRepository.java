package com.huongproject.redisProject.repository;

import com.huongproject.redisProject.entity.TestEntity;
import org.springframework.data.repository.CrudRepository;

public interface RedisRepository extends CrudRepository<TestEntity, Long> {
}
