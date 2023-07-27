package com.plannerapp.service;

import com.plannerapp.model.binding.UserAssignedTasksBindingModel;
import com.plannerapp.repo.TaskRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<UserAssignedTasksBindingModel> findAllTasksById(HttpSession httpSession) {
        Long id = (Long) httpSession.getAttribute("id");
        return taskRepository.findAllTasksByUserId(id);
    }
}
