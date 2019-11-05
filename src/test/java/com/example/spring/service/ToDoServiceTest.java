package com.example.spring.service;

import com.example.spring.model.ToDo;
import com.example.spring.repo.ToDoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class ToDoServiceTest {

    @Autowired
    private ToDoRepository toDoRepository;

    @Test
    void getAllToDos() {


        ToDo toDo = new ToDo("Todo Sample", true);
        toDoRepository.save(toDo);

        ToDoService toDoService = new ToDoService(toDoRepository);
        ToDo firstToDo = toDoService.findAll().get(0);
//        ToDo lastToDo =toDoList.get(toDoList.size() - 1);

        assertEquals(toDo.getText(), firstToDo.getText());
        assertEquals(toDo.isCompleted(), firstToDo.isCompleted());
        assertEquals(toDo.getId(), firstToDo.getId());

    }
}
