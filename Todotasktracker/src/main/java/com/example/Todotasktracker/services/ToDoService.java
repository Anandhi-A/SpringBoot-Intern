package com.example.Todotasktracker.services;

import com.example.Todotasktracker.models.ToDo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ToDoService {
    List<ToDo> todo = new ArrayList<>(
            Arrays.asList(
                    new ToDo(1, "going for a walk ", "Status.COMPLETED"),
                    new ToDo(2, "washing clothes", "Status.COMPLETED"))
    );

    public List<ToDo> getToDo() {
        return todo;
    }

    public ToDo getById(@PathVariable int id) {
        for (ToDo x : todo) {
            if (id == x.getId()) {
                return x;
            }
        }
        return null;
    }

    public String posttask(ToDo task) {
        todo.add(task);
        return "Task added successfully";
    }

    public String edittask(@PathVariable int id, String status) {
        for (ToDo x : todo) {
            if (id == x.getId()) {
                x.setStatus(status);
                return "Task updated successfully";
            }
        }
        return "Task not found";
    }

    public String deletetask(@PathVariable int id) {
        for (ToDo x : todo) {
            if (id == x.getId()) {
                todo.remove(x);
                return "Task deleted successfully";
            }
        }
        return "Task not found";
    }
}