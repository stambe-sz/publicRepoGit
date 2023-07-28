package com.plannerapp.model.binding;
import com.plannerapp.model.entity.User;
import com.plannerapp.model.enums.PriorityNameEnum;

import java.time.LocalDate;

public class UserAssignedTasksBindingModel {

    private Long id;
    private String description;
    private LocalDate dueDate;
    private String priority;

    public UserAssignedTasksBindingModel(Long id, String description, LocalDate dueDate, PriorityNameEnum priority) {
        this.id = id;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority.name();
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

}
