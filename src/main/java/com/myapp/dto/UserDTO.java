package com.myapp.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends BaseDTO{
    private String userName;
    private String password;
}
