package com.example.demo.service;

import com.example.demo.mapper.TaskInDTOToTask;
import com.example.demo.persistence.Entity.Task;
import com.example.demo.persistence.repository.TaskRepository;
import com.example.demo.service.dto.TaskInDTO;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskInDTOToTask mapperTask;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapperTask) {
        this.repository = repository;
        this.mapperTask = mapperTask;
    }

    public Task createTask(TaskInDTO taskInDTO){
        Task task = mapperTask.map(taskInDTO);
        return this.repository.save(task);
    }
}
