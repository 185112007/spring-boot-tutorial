package com.gafur.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "vehicle")
@Data
public class Vehicle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "v_type")
    private String type;
    private String modelCode;
    private String brandName;
    private LocalDate launchDate;
}
