package com.ceschin.todoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ceschin.todoapi.model.Task;
import com.ceschin.todoapi.repository.TaskRepository;


@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    public List<Task> listAllTasks(){
        return taskRepository.findAll();
    }
    
    public ResponseEntity<Task> getTaskById(Long id){
        return taskRepository.findById(id)
           .map(task -> ResponseEntity.ok().body(task))
           .orElse(ResponseEntity.notFound().build());
    }

}    
