package com.smhj.ProductService.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
public class Product extends BaseModel {
    @Column(nullable = false)
    private String title;

    private String description;
    private Long price;
    private String image;
    private Long quantity;

    @ManyToOne
    private Category category;

    private boolean isAvailable;
}
