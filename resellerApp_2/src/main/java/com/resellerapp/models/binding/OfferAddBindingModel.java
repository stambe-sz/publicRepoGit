package com.resellerapp.models.binding;

import com.resellerapp.enums.ConditionEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class OfferAddBindingModel {

    @Size(min = 2,max = 50, message = "Description length must be between 2 and 50 characters!")
    @NotNull
    private String description;
    
    @Positive(message = "Price must be positive number!")
    @NotNull
    private Double price;
    
    @NotNull(message = "You must select a condition!")
    private ConditionEnum condition;

    public OfferAddBindingModel() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ConditionEnum getCondition() {
        return condition;
    }

    public void setCondition(ConditionEnum condition) {
        this.condition = condition;
    }
}
