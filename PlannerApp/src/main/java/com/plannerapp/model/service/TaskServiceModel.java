package com.plannerapp.model.service;

import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.entity.User;
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
    private Priority priority;
    private User user;
}
