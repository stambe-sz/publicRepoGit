package com.resellerapp.controller;

import com.resellerapp.model.binding.UserLoginBindingModel;
import com.resellerapp.model.binding.UserRegisterBindingModel;
import com.resellerapp.model.service.UserServiceModel;
import com.resellerapp.service.UserService;
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
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() ||
                !userRegisterBindingModel.getPassword()
                        .equals(userRegisterBindingModel.getConfirmPassword())) {

            redirectAttributes.addFlashAttribute
                    ("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);


            return "redirect:register";
        }
        userService.registerUser(modelMapper
                .map(userRegisterBindingModel, UserServiceModel.class));

        return "redirect:login";

    }

    @GetMapping("/login")
    public String login(Model model) {
        if (!model.containsAttribute("isFound")){
            model.addAttribute("isFound",true);
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);

            return "redirect:login";
        }
        UserServiceModel userServiceModel = userService
                .findUserByUsernameAndPassword(userLoginBindingModel
                        .getUsername(), userRegisterBindingModel().getPassword());

        if (userServiceModel == null) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
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

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel(){
        return new UserLoginBindingModel();
    }
}
