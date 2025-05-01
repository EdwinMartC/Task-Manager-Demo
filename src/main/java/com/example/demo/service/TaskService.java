package com.example.demo.service;

import com.example.demo.exceptions.ToDoExceptions;
import com.example.demo.mapper.TaskInDTOToTask;
import com.example.demo.persistence.Entity.Task;
import com.example.demo.persistence.Entity.TaskStatus;
import com.example.demo.persistence.repository.TaskRepository;
import com.example.demo.service.dto.TaskInDTO;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Task> findAllTask(){
        return this.repository.findAll();
    }

    public List<Task> findAllByTaskstatus(TaskStatus taskStatus){
        return this.repository.findAllByTaskstatus(taskStatus);
    }

    @Transactional
    public void updateTaskAsFinished(Long id){
        Optional<Task> oTask = this.repository.findById(id);
        if(oTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        else
            this.repository.markTaskAsFinished(id);
    }

    @Transactional
    public void deleteById(Long id){
        Optional<Task> oTask = this.repository.findById(id);
        if(oTask.isEmpty()) {
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        else
            this.repository.deleteById(id);
    }
}
