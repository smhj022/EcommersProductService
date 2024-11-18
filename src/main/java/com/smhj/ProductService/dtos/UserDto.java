package com.smhj.ProductService.dtos;

import com.smhj.ProductService.models.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {

    private String name;
    private String email;
    private List<Role> roles;

}
