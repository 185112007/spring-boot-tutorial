package com.gafur.hazelcastcache.repo;

import com.gafur.hazelcastcache.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
    public Car getCarById(Long id);
}
