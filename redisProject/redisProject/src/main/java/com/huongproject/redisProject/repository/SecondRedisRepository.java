package com.huongproject.redisProject.repository;

import com.huongproject.redisProject.entity.SecondEntity;
import org.springframework.data.repository.CrudRepository;

public interface SecondRedisRepository extends CrudRepository<SecondEntity, Long> {
}
