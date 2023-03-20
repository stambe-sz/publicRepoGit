package com.resellerapp.models.views;

import com.resellerapp.models.entity.Condition;

import java.util.UUID;

public class OfferViewModel {

    private UUID id;
    private String description;
    private Double price;
    private Condition condition;

    public OfferViewModel() {
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

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
