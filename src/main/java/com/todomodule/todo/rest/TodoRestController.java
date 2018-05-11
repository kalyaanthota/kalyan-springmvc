package com.todomodule.todo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todomodule.DAO.TodoJDBCTemplate;
import com.todomodule.model.Todo;
import com.todomodule.todo.service.TodoService;

@RestController
public class TodoRestController {
	@Autowired
	private TodoService service;

	@RequestMapping(value = "/todo/", method = RequestMethod.GET)
	public List<Todo> listAllTodos() {
		List<Todo> users = service.retrieveTodos("");
		return users;
	}

	@RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
	public Todo retrieveTodo(@PathVariable("id") int id) {
		return service.retrieveTodo(id);
	}
	
	
	@RequestMapping(value = "/delete-todo/{id}", method = RequestMethod.GET)
	public List<Todo> deleteTodo(@PathVariable("id") int id) {
		service.deleteTodo(id);
		List<Todo> users = service.retrieveTodos("");
		return users;
	}
	
	
}
