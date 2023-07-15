package com.resellerapp.model.service;

import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class OfferServiceModel {

    private Long id;
    private String description;
    private Double price;
    private Condition condition;
    private User user;
    private User buyer;
}
