package com.resellerapp.service;

import com.resellerapp.model.binding.AllOtherOffersBindingModel;
import com.resellerapp.model.binding.UserBoughtOffersBindingModel;
import com.resellerapp.model.binding.UserOfferInfoBindingModel;
import com.resellerapp.model.entity.Offer;
import com.resellerapp.model.service.OfferServiceModel;
import com.resellerapp.repository.OfferRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

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
        return offerRepository.findAllOffersByUserId(id);
    }

    public List<UserBoughtOffersBindingModel> findItemsByUserId(HttpSession httpSession) {
        Long id = (Long) httpSession.getAttribute("id");
        return offerRepository.findBoughtItemsByUserId(id);

    }

    public List<AllOtherOffersBindingModel> findAllOtherOffers(HttpSession httpSession) {
        Long id = (Long) httpSession.getAttribute("id");
        return offerRepository.findAllOtherOffers(id);
    }

    public void deleteOffer(Long id) {
        Optional<Offer> offer = offerRepository.findById(id);
        offerRepository.delete(offer.get());
    }
}
