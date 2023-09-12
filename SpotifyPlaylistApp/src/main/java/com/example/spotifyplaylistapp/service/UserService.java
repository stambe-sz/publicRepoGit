package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.entity.Song;
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
        User user = modelMapper.map(userServiceModel, User.class);
        userRepository.save(user);
    }

    public UserServiceModel findUserByUsernameAndPassword(String username, String password) {
        User foundUser = userRepository.
                findByUsernameAndPassword(username, password).orElse(null);
        if (foundUser == null) {
            return null;
        }
        UserServiceModel u = modelMapper.map(foundUser, UserServiceModel.class);
        return u;
    }

    public void loginUser(Long id, String username, HttpSession httpSession) {
        httpSession.setAttribute("id", id);
        httpSession.setAttribute("username", username);
    }

    public void addSongToUser(Long userId, Song song) {

        User user = this.userRepository.findById(userId).orElse(null);
        assert user != null;
        boolean isNotExistSong = user.getPlaylist().stream().noneMatch(s ->
            s.getId().equals(song.getId()));
        if (isNotExistSong){
            user.getPlaylist().add(song);
            this.userRepository.save(user);
        }

    }
}
