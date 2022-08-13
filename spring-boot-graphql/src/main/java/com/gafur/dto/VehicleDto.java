package com.gafur.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VehicleDto {
    private String type;
    private String modelCode;
    private String brandName;
    private LocalDate launchDate;
}
