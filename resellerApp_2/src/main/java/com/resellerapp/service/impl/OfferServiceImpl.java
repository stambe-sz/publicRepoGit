package com.resellerapp.service.impl;

import com.resellerapp.models.entity.Offer;
import com.resellerapp.models.services.OfferServiceModel;
import com.resellerapp.repository.OfferRepository;
import com.resellerapp.sec.CurrentUser;
import com.resellerapp.service.ConditionService;
import com.resellerapp.service.OfferService;
import com.resellerapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final ConditionService conditionService;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, ConditionService conditionService) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.conditionService = conditionService;
    }

    @Override
    public void addOffer(OfferServiceModel offerServiceModel) {

        Offer offer = modelMapper.map(offerServiceModel,Offer.class);
        offer.setUser(userService.findById(currentUser.getId()));
        offer.setBuyer(userService.findById(currentUser.getId()));
        offer.setCondition(conditionService
                .findByConditionEnum(offerServiceModel.getCondition()));

        offerRepository.save(offer);
    }
}
