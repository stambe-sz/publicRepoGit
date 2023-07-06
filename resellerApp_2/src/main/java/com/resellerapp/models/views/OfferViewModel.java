package com.resellerapp.models.views;

import com.resellerapp.models.entity.Condition;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OfferViewModel {

    private String id;
    private String description;
    private Double price;
    private Condition condition;

}
