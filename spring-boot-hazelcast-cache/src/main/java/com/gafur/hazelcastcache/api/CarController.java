package com.gafur.hazelcastcache.api;

import com.gafur.hazelcastcache.model.Car;
import com.gafur.hazelcastcache.repo.CarRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class CarController {
    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/{id}")
    public Car getCar(@PathVariable Long id) {
        return carRepository.getCarById(id);
    }

    @GetMapping
    public Iterable<Car> getCars() {
        return carRepository.findAll();
    }

    @PostMapping
    public Car save(@RequestBody Car car) {
        return carRepository.save(car);
    }
}
