package com.smhj.ProductService.models;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Category extends BaseModel {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
