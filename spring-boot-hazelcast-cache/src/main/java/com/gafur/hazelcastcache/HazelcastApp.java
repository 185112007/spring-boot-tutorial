package com.gafur.hazelcastcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(exclude = HazelcastAutoConfiguration.class)
public class HazelcastApp {

    public static void main(String[] args) {
        SpringApplication.run(HazelcastApp.class, args);
    }
}
