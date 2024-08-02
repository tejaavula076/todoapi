package com.example.todo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.todo.service.TodoH2Service;
import com.example.todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
@RestController
public class TodoController {
    @Autowired
    public TodoH2Service a;

    @GetMapping("/todos")
    public ArrayList<Todo> getalltodos() {
        return a.getalltodos();
    }

    @PostMapping("/todos")
    public Todo addnewtodo(@RequestBody Todo addelement) {
        return a.addnewtodo(addelement);
    }

    @GetMapping("/todos/{id}")
    public Todo getparticularid(@PathVariable("id") int id) {
        return a.getparticularid(id);
    }

    @PutMapping("/todos/{id}")
    public Todo updateid(@PathVariable("id") int id, @RequestBody Todo addelement) {
        return a.updateid(id, addelement);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteid(@PathVariable("id") int id) {
        a.deleteid(id);
    }
}