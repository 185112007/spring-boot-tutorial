package com.gafur.api;

import com.gafur.dto.VehicleDto;
import com.gafur.model.Vehicle;
import com.gafur.repo.VehicleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleRepo vehicleRepo;

    @QueryMapping
    public List<Vehicle> getVehicles(@Argument String type){
        return vehicleRepo.getByTypeLike(type);
    }

    @QueryMapping
    public Optional<Vehicle> getById(@Argument Long id){
        return vehicleRepo.findById(id);
    }

    @MutationMapping
    public Vehicle createVehicle(@Argument(name = "vehicle") VehicleDto vehicleDto){

        return vehicleRepo.save(dtoToVehicle(vehicleDto));
    }

    private Vehicle dtoToVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = new Vehicle();
        vehicle.setType(vehicleDto.getType());
        vehicle.setModelCode(vehicleDto.getModelCode());
        vehicle.setBrandName(vehicleDto.getBrandName());
        vehicle.setLaunchDate(LocalDate.now());
        return vehicle;
    }
}
