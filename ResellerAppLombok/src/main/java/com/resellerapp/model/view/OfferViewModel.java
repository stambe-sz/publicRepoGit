package com.resellerapp.model.view;

import com.resellerapp.model.entity.Condition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OfferViewModel {
    private String description;
    private Double price;
    private Condition condition;
}
