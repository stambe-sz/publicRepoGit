package com.likebookapp.model.service;

import com.likebookapp.model.view.UserViewModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostServiceModel extends BaseServiceModel {

    private String content;

    private UserServiceModel user;

    private List<UserViewModel> userLikes;

    private MoodServiceModel mood;

}
