package com.example.Todotasktracker.controllers;

import com.example.Todotasktracker.models.ToDo;
import com.example.Todotasktracker.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @GetMapping
    public List<ToDo> getTask() {
        return toDoService.getToDo();

    }

    @GetMapping("/{id}")
    public ToDo getTask(@PathVariable int id) {
        return toDoService.getById(id);
    }

    @PostMapping
    public String postTask(@RequestBody ToDo task) {
        return toDoService.posttask(task);
    }

    @PutMapping("/{id}")
    public String putTask(@PathVariable int id, @RequestBody String status) {

        return toDoService.edittask(id, status);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id) {
        return toDoService.deletetask(id);
    }
}