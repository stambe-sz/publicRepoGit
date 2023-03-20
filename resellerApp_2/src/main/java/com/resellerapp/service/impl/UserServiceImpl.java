package com.resellerapp.service.impl;

import com.resellerapp.models.entity.User;
import com.resellerapp.models.services.UserServiceModel;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.sec.CurrentUser;
import com.resellerapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
       User user = modelMapper.map(userServiceModel,User.class);

        return modelMapper
                .map(userRepository.save(user),UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        UserServiceModel foundUser = userRepository.
                findByUsernameAndPassword(username,password)
                .map(user -> modelMapper.map(user,UserServiceModel.class))
                .orElse(null);
        return foundUser;
    }

    @Override
    public void loginUser(UUID id, String username) {
//        httpSession.setAttribute("userId", id);
        currentUser.setId(id);
        currentUser.setUsername(username);
    }

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }
}
