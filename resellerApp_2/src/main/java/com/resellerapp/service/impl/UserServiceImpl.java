package com.resellerapp.service.impl;

import com.resellerapp.models.entity.User;
import com.resellerapp.models.services.UserServiceModel;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

import javax.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
       User user = modelMapper.map(userServiceModel,User.class);

        return modelMapper
                .map(userRepository.save(user),UserServiceModel.class);
    }

    @Override
	public UserServiceModel findByUsernameAndPassword(String username, String password) {
    	User foundUser = this.userRepository.findByUsernameAndPassword(username, password).orElse(null);
        UserServiceModel u = this.modelMapper.map(foundUser, UserServiceModel.class);
        return u;
    }

    @Override
    public void loginUser(String id, String username, HttpSession httpSession) {
//        httpSession.setAttribute("userId", id);
//        currentUser.setId(id);
//        currentUser.setUsername(username);
        httpSession.setAttribute("id", id);
        httpSession.setAttribute("username", username);
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }
}
