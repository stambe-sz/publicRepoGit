package com.plannerapp.controller;

import com.plannerapp.model.binding.TaskAddBindingModel;
import com.plannerapp.model.service.TaskServiceModel;
import com.plannerapp.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
    @PostMapping("/add")
    public String addConfirm(@Valid TaskAddBindingModel taskAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             HttpSession httpSession){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("taskAddBindingModel",taskAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskAddBindingModel",bindingResult);

            return "redirect:add";
        }
        taskService.addTask(modelMapper
                .map(taskAddBindingModel, TaskServiceModel.class)
                ,httpSession);

        return "redirect:/";

    }
}
