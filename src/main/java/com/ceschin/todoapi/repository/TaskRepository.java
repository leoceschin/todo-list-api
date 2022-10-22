package com.ceschin.todoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ceschin.todoapi.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
