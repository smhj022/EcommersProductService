package com.smhj.ProductService.inhertancedemo.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity(name = "jt_student")
public class Student extends User {
    private int psp;
    private String batch;
}
