package com.smhj.ProductService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();  // Set the creation date to the current date
        updatedAt = new Date();  // Set the update date to the current date
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();  // Update the date to the current date
    }
}
