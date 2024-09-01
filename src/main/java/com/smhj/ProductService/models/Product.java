package com.smhj.ProductService.models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class Product extends BaseModel {
    private String title;
    private String description;
    private Long price;
    private Category category;
    private List<String> allowedUser;
}
