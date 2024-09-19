package com.smhj.ProductService.inhertancedemo.mappedsuperclass;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
// MappedSuperClass -> It will create table only for child with
// columns inherited from Parent. No class for user
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
}
