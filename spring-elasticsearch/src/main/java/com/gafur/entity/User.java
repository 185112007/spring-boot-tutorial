package com.gafur.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Document(indexName = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;
    @Field(value = "name", type = FieldType.Text)
    private String name;
    @Field(value = "surName", type = FieldType.Text)
    private String surName;
    @Field(value = "address", type = FieldType.Text)
    private String address;
    @Field(value = "dateOfBirth", type = FieldType.Date)
    private LocalDate dateOfBirth;
}
