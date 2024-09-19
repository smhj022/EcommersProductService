package com.smhj.ProductService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


// cardinality (relationships)
//https://www.baeldung.com/jpa-cascade-types
//https://www.baeldung.com/hibernate-lazy-eager-loading
//https://www.baeldung.com/hibernate-fetchmode
// fetch mode vs fetch type

// fetchMode -> (N+1 problem) How to execute query
// fetchType -> When to execute the query

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    // long vs Long -> we are using Long as it will help in serialization
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
