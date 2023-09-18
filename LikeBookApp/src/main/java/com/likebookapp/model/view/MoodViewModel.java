package com.likebookapp.model.view;

import com.likebookapp.model.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MoodViewModel extends BaseViewModel {
    private String description;
    private List<PostViewModel> posts;
}
