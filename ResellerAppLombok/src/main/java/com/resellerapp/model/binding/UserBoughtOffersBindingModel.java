package com.resellerapp.model.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserBoughtOffersBindingModel {
    private Long id;
    private String description;
    private Double price;
}
