package com.resellerapp.model.binding;

import com.resellerapp.model.enums.ConditionNameEnum;

public class AllOtherOffersBindingModel {
    private Long id;
    private String description;
    private Double price;
    private String sellerUsername;
    private String condition;

    public AllOtherOffersBindingModel(Long id, String description, Double price, String sellerUsername, ConditionNameEnum condition) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.sellerUsername = sellerUsername;
        this.condition = condition.name();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
