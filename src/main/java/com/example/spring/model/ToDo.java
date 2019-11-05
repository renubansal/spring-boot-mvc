package com.example.spring.model;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class ToDo {

    @Id
    @GeneratedValue
    private long id;
    private String text;
    private boolean completed;

    public ToDo() {
    }

    public ToDo(String text, boolean completed) {

        this.text = text;
        this.completed = completed;
    }

    public ToDo(Long id, String text, boolean completed) {
        this.id = id;
        this.text = text;
        this.completed = completed;
    }


    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean isCompleted() {
        return completed;
    }
}
