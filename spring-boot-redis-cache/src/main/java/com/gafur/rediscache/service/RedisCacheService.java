package com.gafur.rediscache.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisCacheService {

    @Cacheable(cacheNames = "cacheable-method")
    public String longRunningMethod() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        return "Method finished";
    }

    @CacheEvict(cacheNames = "cacheable-method")
    public void clearCache(){
        System.out.println("cache cleared");
    }

}
