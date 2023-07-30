package com.plannerapp.model.service;

import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.entity.User;
import com.plannerapp.model.enums.PriorityNameEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class TaskServiceModel {

    private Long id;
    private String description;
    private LocalDate dueDate;
    private PriorityNameEnum priority;
    private User user;
}
