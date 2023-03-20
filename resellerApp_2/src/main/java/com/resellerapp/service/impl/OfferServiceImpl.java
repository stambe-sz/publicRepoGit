package com.resellerapp.service.impl;

import com.resellerapp.models.entity.Offer;
import com.resellerapp.models.services.OfferServiceModel;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.service.ConditionService;
import com.resellerapp.service.OfferService;
import com.resellerapp.service.UserService;

import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final ConditionService conditionService;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, UserService userService, ConditionService conditionService) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.conditionService = conditionService;
    }

    @Override
    public void addOffer(OfferServiceModel offerServiceModel, HttpSession httpSession) {

        Offer offer = modelMapper.map(offerServiceModel,Offer.class);
        offer.setUser(userService.findById(httpSession.getAttribute("id").toString()));
        offer.setBuyer(userService.findById(httpSession.getAttribute("id").toString()));
        offer.setCondition(conditionService
                .findByConditionEnum(offerServiceModel.getCondition()));

        offerRepository.save(offer);
    }
}
