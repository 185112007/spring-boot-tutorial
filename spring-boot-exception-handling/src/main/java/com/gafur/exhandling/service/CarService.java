package com.gafur.exhandling.service;

import com.gafur.exhandling.dto.CarDto;
import com.gafur.exhandling.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private static final List<CarDto> carDtoList = new ArrayList<>();

    @PostConstruct
    public void init(){
        carDtoList.add(new CarDto("carname 1", "brand 1"));
        carDtoList.add(new CarDto("carname 2", "brand 2"));
    }

    public CarDto getCar(String name){
        return carDtoList.stream()
                .filter(carDto ->
                        carDto.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("car with " + name + " not found"));
    }
}