package com.smhj.ProductService.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jdk.dynalink.linker.LinkerServices;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String name;
}

/*

Lazy Vs Eager loading

Category and Product
to fetch a category by id

in Eager Loading
1. Get category then run another query to get all products by category id
2. Use Join to get in one query

first option should be used when immediate operation on product
Category category = new findCategoryById()
//operation on product



* */
