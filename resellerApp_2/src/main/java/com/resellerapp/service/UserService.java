package com.resellerapp.service;

import com.resellerapp.models.entity.User;
import com.resellerapp.models.services.UserServiceModel;

import java.util.UUID;

import javax.servlet.http.HttpSession;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    void loginUser(String id, String username, HttpSession httpSession);

    User findById(String id);
}
