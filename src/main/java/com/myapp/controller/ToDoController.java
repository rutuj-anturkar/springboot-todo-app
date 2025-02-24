package com.myapp.controller;

import com.myapp.dto.TodoDTO;
import com.myapp.model.Status;
import com.myapp.model.ToDo;
import com.myapp.service.ToDoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class ToDoController {
    private ToDoService toDoService;

    @PostMapping("/user/{userId}")
    public ResponseEntity<?> addTask(@RequestBody @Valid TodoDTO task, @PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(toDoService.createToDo(task, userId));
    }

    @GetMapping
    public ResponseEntity<?> getAllTasks() {
        return ResponseEntity.ok(toDoService.getAllToDos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(toDoService.getTaskById(id));
    }

    @PutMapping
    public ResponseEntity<?> updateTask(@RequestBody TodoDTO updatedTask) {
        return ResponseEntity.ok(toDoService.updateTask(updatedTask));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteTask(@RequestParam Long id) {
        return ResponseEntity.ok(toDoService.deleteTask(id));
    }

    @GetMapping("/filter")
    public ResponseEntity<?> FilterTasksByStatus(@RequestParam(defaultValue = "COMPLETED") Status status) {
        return ResponseEntity.ok(toDoService.filterTasksByStatus(status));
    }

    @GetMapping("/user/filter/{userId}")
    public ResponseEntity<?> getTasksByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(toDoService.getTasksByUserId(userId));
    }

}

