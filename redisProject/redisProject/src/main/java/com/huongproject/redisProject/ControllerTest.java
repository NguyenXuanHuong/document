package com.huongproject.redisProject;

import com.huongproject.redisProject.entity.TestEntity;
import com.huongproject.redisProject.repository.TestRepository;
import com.huongproject.redisProject.service.CacheServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {

//    @Autowired
//    CacheServiceImp cacheServiceImp;

    @Autowired
    TestRepository testRepository;

    @GetMapping("/test-redis")
    public void test(){
//        cacheServiceImp.addDataToRedis(RedisConfig.CACHE_TOKEN_DEVICE_LOGIN_BZB, "test","testValue" );
        testRepository.save(new TestEntity(1L, "ABC"));


    }
}
