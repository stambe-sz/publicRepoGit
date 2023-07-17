package com.resellerapp.service;

import com.resellerapp.model.binding.UserOfferInfoBindingModel;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.service.OfferServiceModel;
import com.resellerapp.repository.OfferRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;
    private final UserService userService;
    private final ConditionService conditionService;

    public OfferService(OfferRepository offerRepository, ModelMapper modelMapper, HttpSession httpSession, UserService userService, ConditionService conditionService) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
        this.userService = userService;
        this.conditionService = conditionService;
    }

    public void addOffer(OfferServiceModel offerServiceModel) {
        Offer offer = modelMapper.map(offerServiceModel,Offer.class);
        offer.setUser(userService.findById((Long) httpSession.getAttribute("id")));
        offer.setCondition(conditionService.findConditionNameEnum(offerServiceModel.getCondition()));

        offerRepository.save(offer);
    }

    public List<UserOfferInfoBindingModel> findUserOffers(HttpSession httpSession) {
        Long id = (Long) httpSession.getAttribute("id");
        return offerRepository.findAll();
    }
}
