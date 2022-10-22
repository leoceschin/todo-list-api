package com.ceschin.todoapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceschin.todoapi.model.Task;
import com.ceschin.todoapi.service.TaskService;


@RestController
public class TaskController {
    
    @Autowired
    TaskService taskService;

    @PostMapping("/create")
    public Task cadastrarTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @GetMapping("/tasks")
    public List<Task> listarTasks(){
        return taskService.listAllTasks();
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> listTaskById(@PathVariable(value = "id") Long id){
        return taskService.getTaskById(id);
    }

}
