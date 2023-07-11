package com.resellerapp.model.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserRegisterBindingModel {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
}
