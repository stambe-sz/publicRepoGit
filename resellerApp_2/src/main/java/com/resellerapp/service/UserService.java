package com.resellerapp.service;

import com.resellerapp.models.entity.User;
import com.resellerapp.models.services.UserServiceModel;

import java.util.UUID;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(UUID id, String username);

    User findById(UUID id);
}
