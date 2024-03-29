package com.likebookapp.service;

import com.likebookapp.model.entity.User;
import com.likebookapp.model.service.UserServiceModel;
import com.likebookapp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;

    public UserService(UserRepository userRepository, ModelMapper modelMapper, HttpSession httpSession) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    public void registerUser(UserServiceModel userServiceModel) {

        User user = modelMapper.map(userServiceModel, User.class);
        this.userRepository.save(user);
    }

    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        User foundUser = this.userRepository
                .findUserByUsernameAndPassword(username,password)
                .orElse(null);
        if (foundUser == null){
            return null;
        }
        UserServiceModel u = modelMapper.map(foundUser, UserServiceModel.class);

        return u;
    }

    public void loginUser(Long id, String username, HttpSession httpSession) {
        httpSession.setAttribute("id",id);
        httpSession.setAttribute("username", username);
    }
}
