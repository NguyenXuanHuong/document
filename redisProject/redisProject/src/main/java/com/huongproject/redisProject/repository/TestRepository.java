package com.huongproject.redisProject.repository;

import com.huongproject.redisProject.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public void save(TestEntity test){
        redisTemplate.opsForHash().put("Product", test.getTestId(), test);
    }




}
