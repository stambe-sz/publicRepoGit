package com.plannerapp.model.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
public class UserRegisterBindingModel {
    @Size(min = 3, max = 20,message = "Username length must be between 3 and 20 characters")
    public String username;
    @Email(message = "Email can not be empty")
    public String email;
    @Size(min = 3, max = 20,message = "Password length must be between 3 and 20 characters")
    public String password;
    @Size(min = 3, max = 20,message = "")
    public String confirmPassword;
}
