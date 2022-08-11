package com.gafur.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Pet", description = "Pet Model")
public class Pet {
    @ApiModelProperty("id")
    private int id;
    @ApiModelProperty("name")
    private String name;
    @ApiModelProperty("date")
    private LocalDate date;
}
