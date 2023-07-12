package com.resellerapp.model.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserServiceModel {
    private Long id;
    private String username;
    private String password;
    private String email;
}
