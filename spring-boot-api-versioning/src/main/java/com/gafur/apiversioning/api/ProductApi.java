package com.gafur.apiversioning.api;

import com.gafur.apiversioning.dto.ProductDtoV1;
import com.gafur.apiversioning.dto.ProductDtoV2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class ProductApi {

    /* 1. Uri Versioning */
    // http://localhost:8080/api/v1/product
    @GetMapping("/v1/product")
    public ResponseEntity<ProductDtoV1> pathVersioningV1(){
        return ResponseEntity.ok(new ProductDtoV1("name 1"));
    }

    // http://localhost:8080/api/v2/product
    @GetMapping("/v2/product")
    public ResponseEntity<ProductDtoV2> pathVersioningV2(){
        return ResponseEntity.ok(new ProductDtoV2("name 2", BigDecimal.TEN));
    }

    /* 2. Param Versioning*/
    // http://localhost:8080/api/param/product?apiVersion=1
    @GetMapping(value = "/param/product", params = "apiVersion=1")
    public ResponseEntity<ProductDtoV1> paramVersioningV1(){
        return ResponseEntity.ok(new ProductDtoV1("name 1"));
    }

    // http://localhost:8080/api/param/product?apiVersion=2
    @GetMapping(value = "/param/product", params = "apiVersion=2")
    public ResponseEntity<ProductDtoV2> paramVersioningV2(){
        return ResponseEntity.ok(new ProductDtoV2("name 2", BigDecimal.TEN));
    }

    /* 3. Header Versioning*/
    // http://localhost:8080/api/header/product
    @GetMapping(value = "/header/product", headers = "X-Api-Version=1")
    public ResponseEntity<ProductDtoV1> headerVersioningV1(){
        return ResponseEntity.ok(new ProductDtoV1("name 1"));
    }

    // http://localhost:8080/api/header/product
    @GetMapping(value = "/header/product", headers = "X-Api-Version=2")
    public ResponseEntity<ProductDtoV2> headerVersioningV2(){
        return ResponseEntity.ok(new ProductDtoV2("name 2", BigDecimal.TEN));
    }
}
