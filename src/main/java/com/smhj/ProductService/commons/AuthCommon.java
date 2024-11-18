package com.smhj.ProductService.commons;


import com.smhj.ProductService.dtos.UserDto;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthCommon {

    private final RestTemplate restTemplate;

    public AuthCommon(){
        this.restTemplate = new RestTemplate();
    }

    public UserDto validateToken(String tokenValue){

        //Call user Service to Validate token

        ResponseEntity<UserDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/user/" + tokenValue, UserDto.class);

        if(responseEntity.getBody() == null){
            // token is invalid
            return null;
        }

        return responseEntity.getBody();

    }
}
