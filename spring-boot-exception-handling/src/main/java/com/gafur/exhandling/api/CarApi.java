package com.gafur.exhandling.api;

import com.gafur.exhandling.dto.CarDto;
import com.gafur.exhandling.exception.EntityNotFoundException;
import com.gafur.exhandling.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarApi {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<CarDto> getCar(@RequestParam String name){
        return ResponseEntity.ok(carService.getCar(name));
    }
}
