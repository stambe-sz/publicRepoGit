package com.plannerapp.service;

import com.plannerapp.model.binding.AllAvailableTasksBindingModel;
import com.plannerapp.model.binding.UserAssignedTasksBindingModel;
import com.plannerapp.model.entity.Task;
import com.plannerapp.model.service.TaskServiceModel;
import com.plannerapp.repo.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserService userService;
    private final PriorityService priorityService;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;

    public TaskService(TaskRepository taskRepository, UserService userService, PriorityService priorityService, ModelMapper modelMapper, HttpSession httpSession) {
        this.taskRepository = taskRepository;
        this.userService = userService;
        this.priorityService = priorityService;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    public List<UserAssignedTasksBindingModel> findAllTasksById(HttpSession httpSession) {
        Long id = (Long) httpSession.getAttribute("id");
        return taskRepository.findAllTasksByUserId(id);
    }

    public void addTask(TaskServiceModel taskServiceModel, HttpSession httpSession) {
        Task task = modelMapper.map(taskServiceModel, Task.class);
        task.setPriority(priorityService
                .findPriorityNameEnum(taskServiceModel.getPriority()));

        taskRepository.save(task);
    }

    public List<AllAvailableTasksBindingModel> findAllAvailableTasks() {
        return taskRepository.findAllAvailableTasks();
    }
}
