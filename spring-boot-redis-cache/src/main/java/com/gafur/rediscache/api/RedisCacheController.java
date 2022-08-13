package com.gafur.rediscache.api;

import com.gafur.rediscache.service.RedisCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RedisCacheController {

    @Autowired
    private RedisCacheService cacheService;

    private int counter = 0;

    @GetMapping
    public String cacheControl() {
        try{
            if (counter == 5){
                cacheService.clearCache();
                counter = 0;
            }
            counter++;
            return cacheService.longRunningMethod();
        }catch (InterruptedException ex){
            return ex.getMessage();
        }
    }
}
