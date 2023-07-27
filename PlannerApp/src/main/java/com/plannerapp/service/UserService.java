package com.plannerapp.service;

import com.plannerapp.model.entity.User;
import com.plannerapp.model.service.UserServiceModel;
import com.plannerapp.repo.UserRepository;
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

    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);
        return modelMapper.map(userRepository.save(user), UserServiceModel.class);
    }

    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        User foundUser = this.userRepository.findByUsernameAndPassword(username, password)
                .orElse(null);

        if (foundUser == null) {
            return null;
        }
        UserServiceModel u = modelMapper
                .map(foundUser, UserServiceModel.class);
        return u;
    }

    public void loginUser(Long id, String username, HttpSession httpSession) {
        httpSession.setAttribute("id",id);
        httpSession.setAttribute("username",username);
    }
}
