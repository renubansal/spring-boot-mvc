package com.example.spring.controller;

import com.example.spring.model.ToDo;
import com.example.spring.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToDoController {
    @Autowired
    ToDoService toDoService;

    @GetMapping("/todos")
    ResponseEntity<List<ToDo>> getAllTodos() {
        return new ResponseEntity<>(toDoService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/todos")
    ResponseEntity<ToDo> create(@RequestBody ToDo toDo){
        return new ResponseEntity<>(toDoService.save(toDo),HttpStatus.CREATED);
    }
}
