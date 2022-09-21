package com.huongproject.redisProject.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CacheServiceImp{
    @Autowired
    CacheManager cacheManager;

    public Object getDataFromRedis(String cacheName, Object key) {
        if (cacheManager.getCache(cacheName) != null &&
                cacheManager.getCache(cacheName).get(key) != null) {
            return cacheManager.getCache(cacheName).get(key).get();
        }
        return null;
    }

    public void addDataToRedis(String cacheName, Object key, Object value) {
        try {
            if (cacheManager.getCache(cacheName) != null) {
                cacheManager.getCache(cacheName).put(key, value);
            }
        } catch (Exception e) {
            log.error("Have error when storing Data in redis: ", e.getMessage());
        }

    }
}
