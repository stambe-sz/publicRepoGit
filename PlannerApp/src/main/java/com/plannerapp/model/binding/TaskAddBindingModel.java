package com.plannerapp.model.binding;

import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.entity.User;
import com.plannerapp.model.enums.PriorityNameEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class TaskAddBindingModel {
    @NotNull
    @Size(min = 2, max = 50, message = "Description length must be between 2 and 50 characters")
    private String description;

    @NotNull
    @Future(message = "The dueDate must be a positive in the future.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;
    @NotBlank(message = "You must select a priority!")
    private String priority;
}
