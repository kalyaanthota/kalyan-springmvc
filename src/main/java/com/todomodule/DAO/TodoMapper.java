package com.todomodule.DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.todomodule.model.Todo;

public class TodoMapper implements RowMapper<Todo> {
   public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
	  
	   Todo todo = new Todo();
	   todo.setId(rs.getInt("id"));
	   todo.setDesc(rs.getString("desce"));
	   todo.setDone(Boolean.parseBoolean(rs.getString("isdone")));
	   todo.setTargetDate(rs.getDate("TARGETDATE"));
	  todo.setUser(rs.getString("USER"));
      return todo;
   }
}