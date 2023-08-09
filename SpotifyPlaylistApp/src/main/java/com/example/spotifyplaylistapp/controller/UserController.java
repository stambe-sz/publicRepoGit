package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.binding.UserLoginBindingModel;
import com.example.spotifyplaylistapp.model.binding.UserRegisterBindingModel;
import com.example.spotifyplaylistapp.model.service.UserServiceModel;
import com.example.spotifyplaylistapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;

    public UserController(UserService userService, ModelMapper modelMapper, HttpSession httpSession) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String confirmRegister(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfPassword())) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return "redirect:register";
        }
        userService.registerUser(modelMapper
                .map(userRegisterBindingModel, UserServiceModel.class));


        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (model.containsAttribute("isFound")) {
            model.addAttribute("isFound", true);
        }
        return "login";
    }

    @PostMapping("/login")
    public String confLogin(@Valid UserLoginBindingModel userLoginBindingModel,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);

            return "redirect:login";
        }

        UserServiceModel userServiceModel = userService
                .findUserByUsernameAndPassword(userLoginBindingModel.getUsername(),
                        userLoginBindingModel.getPassword());
        if (userServiceModel == null){
            redirectAttributes.addFlashAttribute("userLoginBindingModel",userLoginBindingModel);
            redirectAttributes.addFlashAttribute("isFound",false);
            return "redirect:login";
        }

        userService.loginUser(userServiceModel.getId(),
                userServiceModel.getUsername(),httpSession);

        return "redirect:/";

    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }
}
