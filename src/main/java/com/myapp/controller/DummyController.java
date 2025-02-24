package com.myapp.controller;

import com.myapp.model.ToDo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/dummy")
public class DummyController {
    public DummyController(){
        System.out.println("In Constructor of " + getClass());
    }
    @GetMapping
    public ResponseEntity<?> testGetDummy(){
//        List<ToDo> dummyTodos = List.of(new ToDo(1L,"task1","desc1", LocalDate.now(),null));
        return ResponseEntity.ok("Testing");
    }

}

