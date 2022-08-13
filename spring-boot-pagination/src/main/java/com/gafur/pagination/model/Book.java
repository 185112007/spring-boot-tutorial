package com.gafur.pagination.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String author;
    private String isbn;
    private String title;
    private LocalDate publishDate;

}
