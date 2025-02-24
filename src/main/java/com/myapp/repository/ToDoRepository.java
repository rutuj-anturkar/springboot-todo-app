package com.myapp.repository;

import com.myapp.model.Status;
import com.myapp.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo,Long> {
    // add derived finder method to list all tasks by status
    List<ToDo> findByStatus(Status status);
    List<ToDo> findByUserId(Long userId);
}
