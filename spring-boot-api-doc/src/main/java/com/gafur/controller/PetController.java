package com.gafur.controller;

import com.gafur.model.Pet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Api("PetController")
public class PetController {

    private List<Pet> petList = new ArrayList<>();

    @PostConstruct
    public void init(){
        petList.add(new Pet(1, "", LocalDate.now()));
    }

    @PostMapping
    @ApiOperation(value = "add", notes = "adds Pet")
    public ResponseEntity<Pet> add(@RequestBody @NonNull @ApiParam("pet") Pet pet){
        petList.add(pet);
        return ResponseEntity.ok(pet);
    }

    @GetMapping
    @ApiOperation(value = "listAll", notes = "List All Pets")
    public ResponseEntity<List<Pet>> listAll(){
        return ResponseEntity.ok(petList);
    }

}
