package com.likebookapp.model.binding;

import com.likebookapp.model.service.MoodServiceModel;
import com.likebookapp.model.view.UserViewModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class PostBindingModel {

    private String content;

    private String mood;

}
