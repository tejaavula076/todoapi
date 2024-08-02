/*
 * You can use the following import statements
 * 
 * import org.springframework.web.server.ResponseStatusException;
 * import org.springframework.http.HttpStatus;
 * 
 */
package com.example.todo.service;

import org.springframework.web.server.ResponseStatusException;

import com.example.todo.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import java.util.*;

import com.example.todo.model.Todo;
import com.example.todo.model.TodoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

// Do not modify the below code
@Service
public class TodoH2Service implements TodoRepository {

    @Autowired
    private JdbcTemplate db;

    // Write your code here
    @Override
    public ArrayList<Todo> getalltodos() {

        List<Todo> aok = db.query("select * from TODOLIST", new TodoRowMapper());
        ArrayList<Todo> er = new ArrayList<>(aok);
        return er;
    }

    @Override
    public Todo addnewtodo(Todo addelement) {
        db.update("insert into TODOLIST(todo,priority,status)values(?,?,?)", addelement.getTodo(),
                addelement.getPriority(), addelement.getStatus());
        Todo out = db.queryForObject("select * from TODOLIST where todo=? and priority=? ", new TodoRowMapper(),
                addelement.getTodo(), addelement.getPriority());
        return out;

    }

    @Override
    public Todo getparticularid(int id) {
        try {
            Todo hjk = db.queryForObject("select * from TODOLIST where id=?", new TodoRowMapper(), id);
            return hjk;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Todo updateid(int id, Todo addelement) {
        if (addelement.getTodo() != null) {
            db.update("update TODOLIST set todo=? where id=?", addelement.getTodo(), id);
        }
        if (addelement.getPriority() != null) {
            db.update("update TODOLIST set priority=? where id=?", addelement.getPriority(), id);
        }
        if (addelement.getStatus() != null) {
            db.update("update TODOLIST set status=? where id=?", addelement.getStatus(), id);
        }
        return getparticularid(id);
    }

    @Override
    public void deleteid(int id) {
        db.update("delete from TODOLIST where id=?", id);
    }

}
