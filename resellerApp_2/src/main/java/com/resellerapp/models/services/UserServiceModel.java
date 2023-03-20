package com.resellerapp.models.services;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserServiceModel {

    private String id;
    private String username;
    private String email;
    private String password;

    
}
