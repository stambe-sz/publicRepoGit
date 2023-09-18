package com.likebookapp.service;

import com.likebookapp.model.entity.Post;
import com.likebookapp.model.service.PostServiceModel;
import com.likebookapp.model.view.PostViewModel;
import com.likebookapp.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public PostService(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }

    public List<PostServiceModel> getAllOtherPosts(Long userId){

        List<Post> allPosts = this.postRepository.findAll();
        allPosts = allPosts.stream().filter(p -> !p.getUser().getId().equals(userId))
                .collect(Collectors.toList());
        List<PostServiceModel> result = allPosts.stream()
                .map(p -> modelMapper.map(p, PostServiceModel.class))
                .collect(Collectors.toList());
        return result;
    }

    public List<PostServiceModel> getAllMyPosts(Long userId){

        List<Post> allPosts = this.postRepository.findAll();
        allPosts = allPosts.stream().filter(p -> p.getUser().getId().equals(userId))
                .collect(Collectors.toList());
        List<PostServiceModel> result = allPosts.stream()
                .map(p -> modelMapper.map(p, PostServiceModel.class))
                .collect(Collectors.toList());
        return result;
    }
    public PostServiceModel addPost(PostServiceModel post){

        return null;
    }

}
