package com.example.spring;

import com.example.spring.model.ToDo;
import com.example.spring.repo.ToDoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	public CommandLineRunner setup(ToDoRepository todoRepository){
//		return args -> {
//			todoRepository.	save(new ToDo("Add a new test case",true));
//			todoRepository.	save(new ToDo("Make it fail",true));
//			todoRepository.	save(new ToDo("Do changes",false));
//			todoRepository.	save(new ToDo("Pass the test",true));
//
//		};
//	}
}
