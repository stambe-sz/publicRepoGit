package com.plannerapp.model.entity;

import com.plannerapp.model.enums.PriorityNameEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "priorities")
public class Priority extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private PriorityNameEnum name;
    @Column(nullable = false)
    private String description;
    @OneToMany(mappedBy = "priority",fetch = FetchType.EAGER)
    private List<Task> tasks;
}
