package com.resellerapp.model.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
public class UserRegisterBindingModel {
    @Size(min = 3,max = 20)
    private String username;
    @Email
    private String email;
    @Size(min = 3,max = 20)
    private String password;
    @Size(min = 3,max = 20)
    private String confirmPassword;
}
