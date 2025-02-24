package com.myapp.service;

import com.myapp.custom_exceptions.ResourceNotFoundException;
import com.myapp.dto.ApiResponse;
import com.myapp.dto.TodoDTO;
import com.myapp.model.Status;
import com.myapp.model.ToDo;
import com.myapp.model.User;
import com.myapp.repository.ToDoRepository;
import com.myapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ToDoServiceImpl implements ToDoService{
    //implicit autowiring
    private ToDoRepository toDoRepository;
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    @Override
    public TodoDTO createToDo(TodoDTO taskDTO, Long userId) {
        //input task -> no id + returns - persistent task with generated id
        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("Create ToDo Scenario: User not found"));
        //task.setUser(user);
        ToDo task = modelMapper.map(taskDTO,ToDo.class);
        user.addTask(task);
        return modelMapper.map(toDoRepository.save(task),TodoDTO.class);
        //return task;
    }

    @Override
    public List<TodoDTO> getAllToDos() {
        return toDoRepository.findAll().stream().map((task)->modelMapper.map(task, TodoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public TodoDTO updateTask(TodoDTO taskDTO) {
        ToDo task = modelMapper.map(taskDTO,ToDo.class);
        if(toDoRepository.existsById(task.getId())){
            return modelMapper.map(toDoRepository.save(task),TodoDTO.class);
        }
        throw new ResourceNotFoundException("Update Scenario: Task ID Invalid");
    }

    @Override
    public TodoDTO getTaskById(Long id) {

        return modelMapper.map(toDoRepository.findById(id).orElseThrow(()->{
            return new RuntimeException("Task Retrieval Scenario: Task ID Invalid");
        }),TodoDTO.class);
    }

    @Override
    public List<TodoDTO> getTasksByUserId(Long userId) {
        return toDoRepository.findByUserId(userId).stream().map((task)->modelMapper.map(task,TodoDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ApiResponse deleteTask(Long id) {
        if(toDoRepository.existsById(id)){
            toDoRepository.deleteById(id);
            return new ApiResponse("Delete Task with Id: " + id);
        }
        throw new RuntimeException("Deletion Scenario: Task ID Invalid");
    }

    @Override
    public List<TodoDTO> filterTasksByStatus(Status status) {
        return toDoRepository.findByStatus(status).stream().map((task)->modelMapper.map(task,TodoDTO.class)).collect(Collectors.toList());
    }


}
