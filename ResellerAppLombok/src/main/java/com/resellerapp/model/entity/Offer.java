package com.resellerapp.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{

    @Column(nullable = false)
    private String description;
    @Column(nullable = false, columnDefinition = "FOAL")
    private Double price;

    @ManyToOne
    private Condition condition;
    @ManyToOne
    private User user;

}
