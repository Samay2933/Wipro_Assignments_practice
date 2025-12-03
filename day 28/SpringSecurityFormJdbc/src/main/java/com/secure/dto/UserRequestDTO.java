package com.secure.dto;


import lombok.Data;

//when request will be send consits of json data it will interact with DTO first
@Data
public class UserRequestDTO {



    private String username;
    private String password;
    private String role;
}
