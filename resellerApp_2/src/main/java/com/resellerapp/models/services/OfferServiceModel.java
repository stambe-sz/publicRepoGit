package com.resellerapp.models.services;

import com.resellerapp.enums.ConditionEnum;
import com.resellerapp.models.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class OfferServiceModel {

    private String id;
    private String description;
    private Double price;
    private ConditionEnum condition;
    private User user;
    private User buyer;

}
