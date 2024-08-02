package com.example.todo.repository;

import java.util.*;
import com.example.todo.model.Todo;

public interface TodoRepository {
      ArrayList<Todo> getalltodos();

      Todo addnewtodo(Todo addelement);

      Todo getparticularid(int id);

      Todo updateid(int id, Todo addelement);

      void deleteid(int id);

}