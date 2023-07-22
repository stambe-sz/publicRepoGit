package com.plannerapp.model.entity;

import com.plannerapp.model.enums.PriorityNameEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.scheduling.config.Task;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "priorities")
public class Priority extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private PriorityNameEnum name;
    @Column(nullable = false)
    private String description;
    private List<Task> tasks;
}
