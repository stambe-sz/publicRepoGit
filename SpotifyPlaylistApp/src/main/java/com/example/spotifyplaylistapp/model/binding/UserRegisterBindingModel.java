package com.example.spotifyplaylistapp.model.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterBindingModel {

    private String username;
    private String email;
    private String password;
    private String confPassword;
}
