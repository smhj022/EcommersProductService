package com.smhj.ProductService.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryNotFoundException extends Exception{

    Long id;

    public CategoryNotFoundException(Long id, String message){
        super(message);
        this.id = id;
    }
}
