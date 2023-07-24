package com.plannerapp.model.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterBindingModel {
    @NotNull
    @Size(min = 3, max = 20,message = "Username length must be between 3 and 20 characters")
    public String username;
    @Email
    @NotBlank(message = "Email cannot be empty!")
    public String email;
    @NotNull
    @Size(min = 3, max = 20,message = "Password length must be between 3 and 20 characters")
    public String password;
    @Size(min = 3, max = 20,message = "")
    @NotNull
    public String confirmPassword;
}
