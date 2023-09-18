package com.likebookapp.model.service;

import com.likebookapp.model.view.UserViewModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostServiceModel extends BaseServiceModel {

    private String content;

    private UserViewModel user;

    private List<UserViewModel> userLikes;

    private MoodServiceModel mood;

}
