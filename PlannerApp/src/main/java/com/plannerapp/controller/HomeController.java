package com.plannerapp.controller;

import com.plannerapp.model.binding.AllAvailableTasksBindingModel;
import com.plannerapp.model.binding.UserAssignedTasksBindingModel;
import com.plannerapp.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    private final TaskService taskService;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;

    public HomeController(TaskService taskService, ModelMapper modelMapper, HttpSession httpSession) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model){
        if (httpSession.getAttribute("id") == null){
            return "index";
        }
        List<UserAssignedTasksBindingModel> assignedToMe =
            taskService.findAllTasksById(httpSession);
        model.addAttribute("assignedToMe",assignedToMe);

        List<AllAvailableTasksBindingModel> allAvailableTasks =
                taskService.findAllAvailableTasks(httpSession);
        model.addAttribute("allAvailableTasks",allAvailableTasks);

        return "home";
    }
}
