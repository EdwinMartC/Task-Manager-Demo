package com.example.demo.controller;

import com.example.demo.persistence.Entity.Task;
import com.example.demo.persistence.Entity.TaskStatus;
import com.example.demo.service.TaskService;
import com.example.demo.service.dto.TaskInDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO){
        return this.taskService.createTask(taskInDTO);
    }

    @GetMapping
    public List<Task> findAllTask(){
        return this.taskService.findAllTask();
    }

    @GetMapping("/status/{status}")
    public List<Task> findAllByTaskStatus(@PathVariable("status") TaskStatus taskStatus){
        return this.taskService.findAllByTaskstatus(taskStatus);
    }
}
