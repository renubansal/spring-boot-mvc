package com.example.spring;

import com.example.spring.model.ToDo;
import com.example.spring.service.ToDoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest
@ExtendWith(SpringExtension.class)
class ToDoControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ToDoService toDoService;


    @Test
    void getAllToDos() throws Exception {
        List<ToDo> toDoList = new ArrayList<ToDo>();
        toDoList.add(new ToDo(1L, "Eat Thrice", true));
        toDoList.add(new ToDo(2L, "Sleep Twice", true));

        when(toDoService.findAll()).thenReturn(toDoList);

        mockMvc.perform(MockMvcRequestBuilders.get("/todos").contentType(MediaType.APPLICATION_JSON)).
                andExpect(jsonPath("$", hasSize(2))).andDo(print());

    }
}