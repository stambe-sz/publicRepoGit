package com.resellerapp.models.services;

import com.resellerapp.enums.ConditionEnum;
import com.resellerapp.models.entity.User;

import java.util.UUID;

public class OfferServiceModel {

    private UUID id;
    private String description;
    private Double price;
    private ConditionEnum condition;
    private User user;
    private User buyer;

    public OfferServiceModel() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }
}
