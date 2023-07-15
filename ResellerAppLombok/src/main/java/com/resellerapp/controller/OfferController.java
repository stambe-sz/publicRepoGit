package com.resellerapp.controller;

import com.resellerapp.model.binding.OfferAddBindingModel;
import com.resellerapp.model.service.OfferServiceModel;
import com.resellerapp.service.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
public class OfferController {
    private final OfferService offerService;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;

    public OfferController(OfferService offerService, ModelMapper modelMapper, HttpSession httpSession) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    @GetMapping("/add")
    public String add(){
        return "offer-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid OfferAddBindingModel offerAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("offerAddBindingModel",offerAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerAddBindingModel",bindingResult);
            return "redirect:add";
        }

        offerService.addOffer(modelMapper
                .map(offerAddBindingModel, OfferServiceModel.class));

        return "redirect:/";
    }

    @ModelAttribute
    public OfferAddBindingModel offerAddBindingModel(){
        return new OfferAddBindingModel();
    }
}
