package com.resellerapp.service;


import javax.servlet.http.HttpSession;

import com.resellerapp.models.services.OfferServiceModel;

public interface OfferService {
    void addOffer(OfferServiceModel offerServiceModel, HttpSession httpSession);
}
