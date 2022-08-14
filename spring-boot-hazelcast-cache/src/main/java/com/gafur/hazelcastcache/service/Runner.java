package com.gafur.hazelcastcache.service;

import com.gafur.hazelcastcache.model.Car;
import com.gafur.hazelcastcache.repo.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private final CarRepository repository;

    public Runner(CarRepository carRepository){
        this.repository = carRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Car("seria-1", "model-1", "brand-1"));
        repository.save(new Car("seria-2", "model-2", "brand-2"));
        repository.findAll().forEach(System.out::println);
    }
}
