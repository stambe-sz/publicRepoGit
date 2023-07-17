package com.resellerapp.controller;

import com.resellerapp.model.binding.UserBoughtOffersBindingModel;
import com.resellerapp.model.binding.UserOfferInfoBindingModel;
import com.resellerapp.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    private final HttpSession httpSession;
    private final OfferService offerService;

    public HomeController(HttpSession httpSession, OfferService offerService) {
        this.httpSession = httpSession;
        this.offerService = offerService;
    }

    @GetMapping("/")
    public String index(Model model) {
        if (httpSession.getAttribute("id") == null) {
            return "index";
        }

        List<UserOfferInfoBindingModel> myOffers = offerService.findUserOffers(httpSession);
        model.addAttribute("myOffers", myOffers);

        List<UserBoughtOffersBindingModel> boughtItems = offerService.findItemsByUserId(httpSession);
        model.addAttribute("boughtItems", boughtItems);

        return "home";
    }
}
