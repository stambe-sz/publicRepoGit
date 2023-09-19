package com.likebookapp.controller;

import com.likebookapp.model.binding.PostBindingModel;
import com.likebookapp.model.service.MoodServiceModel;
import com.likebookapp.model.service.PostServiceModel;
import com.likebookapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/add")
    public String addPost(){
        return "post-add";
    }

    @PostMapping("/add")
    public String addPosts(@Valid PostBindingModel postBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           HttpSession httpSession){

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("postBindingModel", postBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.postBindingModel", bindingResult);

            return "redirect:add";
        }
        PostServiceModel psm = new PostServiceModel(
                postBindingModel.getContent(),
                null,
                new ArrayList<>(),
                new MoodServiceModel(postBindingModel.getMood(), "")
        );
        this.postService.addPost(psm);

        return null;
    }

    @ModelAttribute
    public PostBindingModel postBindingModel(){
        return new PostBindingModel();
    }
}
