package com.likebookapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final HttpSession httpSession;

    public HomeController(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    @GetMapping("/")
    public String index(){
        if (httpSession.getAttribute("id") != null){
            return "redirect:/home";
        }
        return "index";
    }
    @GetMapping("/home")
    public String home(Model model){

        if (httpSession.getAttribute("id") == null){
            return "redirect:/";
        }

        return "home";
    }

}
