package com.likebookapp.model.view;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostViewModel {

    private String content;

    private UserViewModel user;

    private List<UserViewModel> userLikes;

    private MoodViewModel mood;

    private Long id;
}
