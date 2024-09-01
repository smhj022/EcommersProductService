package com.smhj.ProductService.models;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BaseModel {
    // long vs Long -> we are using Long as it will help in serialization
    private Long id;
}
