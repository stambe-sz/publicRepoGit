package com.resellerapp.controller;

import com.resellerapp.service.OfferService;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final OfferService offerService;

    public HomeController(OfferService offerService) {
        this.offerService = offerService;
    }


    @GetMapping("/")
    public String index(HttpSession httpSession){
        if (httpSession.getAttribute("id") == null){
            return "index";
        }

        return "home";
    }
}
