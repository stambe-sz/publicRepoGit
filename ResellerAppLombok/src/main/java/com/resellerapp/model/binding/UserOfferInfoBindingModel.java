package com.resellerapp.model.binding;

import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.enums.ConditionNameEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class UserOfferInfoBindingModel {
    private Long id;
    private String description;
    private Double price;
    private String condition;

    public UserOfferInfoBindingModel(Long id, String description, Double price, ConditionNameEnum condition) {
        this.id = id;
        this.description = description;
        this.price = price;
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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
