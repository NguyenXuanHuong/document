package com.huongproject.redisProject;

import com.huongproject.redisProject.entity.SecondEntity;
import com.huongproject.redisProject.entity.TestEntity;
import com.huongproject.redisProject.repository.RedisRepository;
import com.huongproject.redisProject.repository.SecondRedisRepository;
import com.huongproject.redisProject.repository.TestRepository;
import com.huongproject.redisProject.service.CacheServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {

    @Autowired
    CacheServiceImp cacheServiceImp;

    @Autowired
    TestRepository testRepository;

    @Autowired
    RedisRepository repository;

    @Autowired
    SecondRedisRepository secondRedisRepository;


    @GetMapping("/test-redis")
    public void test(){
        cacheServiceImp.addDataToRedis("abc", "test","testValue" );
        cacheServiceImp.addDataToRedis("no-expire", "no-expire-key","no-expire-value" );
        cacheServiceImp.addDataToRedis("no-expire", "no-expire-key-1","no-expire-value-1" );
        cacheServiceImp.delete("no-expire", "no-expire-key");
//        testRepository.save(new TestEntity(1L, "ABC"));
//        repository.save(new TestEntity(3l, "huong"));
//        secondRedisRepository.save(new SecondEntity(4l, "Second redis"));
    }
}
