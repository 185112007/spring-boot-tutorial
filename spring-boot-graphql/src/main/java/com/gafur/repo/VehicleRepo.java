package com.gafur.repo;

import com.gafur.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepo extends JpaRepository<Vehicle, Long> {

    List<Vehicle> getByTypeLike(String type);


}
