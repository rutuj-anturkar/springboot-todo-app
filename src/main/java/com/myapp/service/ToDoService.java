package com.myapp.service;

import com.myapp.dto.ApiResponse;
import com.myapp.dto.TodoDTO;
import com.myapp.model.Status;
import com.myapp.model.ToDo;
import java.util.List;

public interface ToDoService {
    TodoDTO createToDo(TodoDTO task, Long userId);
    List<TodoDTO> getAllToDos();
    TodoDTO updateTask(TodoDTO task);
    TodoDTO getTaskById(Long id);
    List<TodoDTO> getTasksByUserId(Long userId);

    ApiResponse deleteTask(Long id);

    List<TodoDTO> filterTasksByStatus(Status status);
}
