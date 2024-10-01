package com.smhj.ProductService.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DuplicateCategoryFoundException extends Exception{

    public DuplicateCategoryFoundException(String categoryName){
        super("Category with name " + categoryName + " is already available");
    }
}
