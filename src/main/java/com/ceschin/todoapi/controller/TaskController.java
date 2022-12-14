package com.ceschin.todoapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ceschin.todoapi.model.Task;
import com.ceschin.todoapi.service.TaskService;


@RestController
public class TaskController {
    
    @Autowired
    TaskService taskService;

    @PostMapping("/create")
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable(value = "id") Long id){
        return taskService.getTaskById(id);
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<Task> updateTaskById(@PathVariable (value="id") Long id, @RequestBody Task task){
        return taskService.updateTaskById(task, id);
    }
    
    @DeleteMapping("/task/{id}")
    public ResponseEntity<Object> deleteTaskById(@PathVariable (value="id") Long id){
        return taskService.deleteById(id);
    }

}
