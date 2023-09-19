package com.likebookapp.service;

import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.User;
import com.likebookapp.model.service.PostServiceModel;
import com.likebookapp.model.service.UserServiceModel;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;

    public PostService(PostRepository postRepository, UserRepository userRepository, ModelMapper modelMapper, HttpSession httpSession) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    public List<PostServiceModel> getAllOtherPosts(Long userId) {

        List<Post> allPosts = this.postRepository.findAll();
        allPosts = allPosts.stream().filter(p -> !p.getUser().getId().equals(userId))
                .collect(Collectors.toList());
        List<PostServiceModel> result = allPosts.stream()
                .map(p -> modelMapper.map(p, PostServiceModel.class))
                .collect(Collectors.toList());
        return result;
    }

    public List<PostServiceModel> getAllMyPosts(Long userId) {

        List<Post> allPosts = this.postRepository.findAll();
        allPosts = allPosts.stream().filter(p -> p.getUser().getId().equals(userId))
                .collect(Collectors.toList());
        List<PostServiceModel> result = allPosts.stream()
                .map(p -> modelMapper.map(p, PostServiceModel.class))
                .collect(Collectors.toList());
        return result;
    }

    public PostServiceModel addPost(PostServiceModel post) {
        String username = (String) this.httpSession.getAttribute("username");
        User foundUser = this.userRepository.findUserByUsername(username).orElse(null);
        if (foundUser == null) { /* TODO Excepton... */ }
        UserServiceModel usm = this.modelMapper.map(foundUser, UserServiceModel.class);
        post.setUser(usm);
        Post postForSave = this.modelMapper.map(post, Post.class);
        Post savedPost = this.postRepository.saveAndFlush(postForSave);
        return this.modelMapper.map(savedPost, PostServiceModel.class);
    }

}
