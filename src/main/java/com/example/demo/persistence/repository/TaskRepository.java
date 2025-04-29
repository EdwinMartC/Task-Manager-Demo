package com.example.demo.persistence.repository;

import com.example.demo.persistence.Entity.Task;
import com.example.demo.persistence.Entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    public List<Task> findAllByTaskstatus(TaskStatus taskStatus);
}
