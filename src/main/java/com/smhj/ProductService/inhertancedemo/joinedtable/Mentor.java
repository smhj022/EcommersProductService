package com.smhj.ProductService.inhertancedemo.joinedtable;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "jt_mentor")
public class Mentor extends User {

    private int rating;
}
