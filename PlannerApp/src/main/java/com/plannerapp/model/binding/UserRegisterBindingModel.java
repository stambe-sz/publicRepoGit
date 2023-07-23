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
    @Size(min = 3, max = 20)
    public String username;
    @Email
    public String email;
    @Size(min = 3, max = 20)
    public String password;
    public String confirmPassword;
}
