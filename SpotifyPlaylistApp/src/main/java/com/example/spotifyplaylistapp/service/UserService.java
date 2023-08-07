package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.model.service.UserServiceModel;
import com.example.spotifyplaylistapp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final HttpSession httpSession;

    public UserService(ModelMapper modelMapper, UserRepository userRepository, HttpSession httpSession) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.httpSession = httpSession;
    }

    public void registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel,User.class);
        userRepository.save(user);
    }
}
