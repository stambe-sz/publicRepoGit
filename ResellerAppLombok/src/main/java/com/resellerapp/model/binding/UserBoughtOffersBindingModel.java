package com.resellerapp.model.binding;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserBoughtOffersBindingModel {
    private Long id;
    private String description;
    private Double price;
}
