package com.example.spring.service;

import com.example.spring.model.ToDo;
import com.example.spring.repo.ToDoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class ToDoServiceTest {

    @Autowired
    private ToDoRepository toDoRepository;

    @AfterEach
    void tearDown(){
        toDoRepository.deleteAll();
    }
    @Test
    void getAllToDos() {
        ToDo toDo = new ToDo("Todo Sample", true);
        toDoRepository.save(toDo);

        ToDoService toDoService = new ToDoService(toDoRepository);
        ToDo firstToDo = toDoService.findAll().get(0);

        assertEquals(toDo.getText(), firstToDo.getText());
        assertEquals(toDo.isCompleted(), firstToDo.isCompleted());
        assertEquals(toDo.getId(), firstToDo.getId());
    }

    @Test
    void saveToDo() {
        ToDoService toDoService = new ToDoService(toDoRepository);
        ToDo sampleToDo = new ToDo("Sample Todo",true);

        toDoService.save(sampleToDo);

        assertEquals(1,toDoRepository.count());
    }

}
