package com.smhj.ProductService.dtos;

import lombok.Getter;
import lombok.Setter;


//DTO -> Data Transfer Object  -> In Spring Boot, DTOs (Data Transfer Objects) are used to transfer data between different
// layers of an application.

@Getter
@Setter
public class FakeStoreProductDto {

    private Long id;
    private String title;
    private String description;
    private Long price;
    private String category;
    private String image;
}
