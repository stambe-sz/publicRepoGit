package com.resellerapp.model.binding;

import com.resellerapp.model.enums.ConditionNameEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
public class OfferAddBindingModel {
    @NotNull
    @Size(min = 2, max = 50,  message = "Description length must be between 2 and 50 characters!")
    private String description;
    @NotNull
    @Positive(message = "Price must be positive number!")
    private Double price;
    @NotNull(message = "You must select a condition!")
    private ConditionNameEnum condition;
}
