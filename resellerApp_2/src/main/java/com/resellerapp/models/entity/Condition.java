package com.resellerapp.models.entity;

import com.resellerapp.enums.ConditionEnum;

import javax.persistence.*;

@Entity
@Table(name = "conditions")
public class Condition extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(unique = true,nullable = false)
    private ConditionEnum name;
    
    @Column(nullable = false)
    private String description;

    public Condition() {
    }

    public ConditionEnum getName() {
        return name;
    }

    public void setName(ConditionEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
