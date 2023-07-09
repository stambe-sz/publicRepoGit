package com.resellerapp.model.entity;

import com.resellerapp.model.enums.ConditionName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "conditions")
public class Condition extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(name = "condition_name", nullable = false, unique = true)
    private ConditionName conditionName;
    @Column(nullable = false)
    private String description;
}
