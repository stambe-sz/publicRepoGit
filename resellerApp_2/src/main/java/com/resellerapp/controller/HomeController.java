package com.resellerapp.controller;

import com.resellerapp.sec.CurrentUser;
import com.resellerapp.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final OfferService offerService;

    public HomeController(CurrentUser currentUser, OfferService offerService) {
        this.currentUser = currentUser;
        this.offerService = offerService;
    }


    @GetMapping("/")
    public String index(){
        if (currentUser.getId() == null){
            return "index";
        }

        return "home";
    }
}
