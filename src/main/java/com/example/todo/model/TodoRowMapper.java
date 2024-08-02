/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 */

// Write your code here
package com.example.todo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

public class TodoRowMapper implements RowMapper<Todo> {
  @Override
  public Todo mapRow(ResultSet rs, int inccount) throws SQLException {
    return new Todo(
        rs.getInt("id"),
        rs.getString("todo"),
        rs.getString("priority"),
        rs.getString("status"));
  }
}
