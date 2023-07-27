package com.plannerapp.controller;

import com.plannerapp.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;

    public TaskController(TaskService taskService, ModelMapper modelMapper, HttpSession httpSession) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
    }

    @GetMapping("/add")
    public String add(){
       if (httpSession.getAttribute("id") == null){
           return "login";
       }
       return "/task-add";
    }
}
