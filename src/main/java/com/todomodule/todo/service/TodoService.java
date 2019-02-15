package com.todomodule.todo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.todomodule.DAO.TodoJDBCTemplate;
import com.todomodule.model.Todo;

@Service
public class TodoService {
	
	private TodoJDBCTemplate tjt = new TodoJDBCTemplate();
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;
	
	
	
	/*static {
		todos.add(new Todo(1, "asdf", "Learn Spring MVC", new Date(),
				false));
		todos.add(new Todo(2, "asdf", "Learn Struts", new Date(), false));
		todos.add(new Todo(3, "asdf", "Learn Hibernate", new Date(),
				false));
	}*/
	
	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails)
			return ((UserDetails) principal).getUsername();

		return principal.toString();
	}

	public List<Todo> retrieveTodos(String user) {
		List<Todo> filteredTodos = new ArrayList<Todo>();

		if (user.equalsIgnoreCase("")) {
			user = getLoggedInUserName();
		} 
		//System.out.println("tjt===="+tjt);
		todos = tjt.retrieveTodos();
			for (Todo todo : todos) {
				if (todo.getUser().equals(user))
					filteredTodos.add(todo);
			
		}
		return filteredTodos;
	}
	
//	public List<Todo> retrieveTodos(String user) {
//		List<Todo> filteredTodos = new ArrayList<Todo>();
//
//		if (user.equalsIgnoreCase("")) {
//			user = getLoggedInUserName();
//		} 
//			for (Todo todo : todos) {
//				if (todo.getUser().equals(user))
//					filteredTodos.add(todo);
//			
//		}
//		return filteredTodos;
//	}

	public Todo retrieveTodo(int id) {
		for (Todo todo : todos) {
			if (todo.getId() == id)
				return todo;
		}
		return null;
	}

	public void updateTodo(Todo todo) {
		//todos.remove(todo);
		//todos.add(todo);
		tjt.update(todo.getId(), todo.getDesc(), todo.getTargetDate(), todo.isDone());
	}

	public void addTodo(String name, String desc, Date targetDate,
			boolean isDone) {
		//todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
		tjt.create(name, desc, targetDate, isDone);
	}

	public void deleteTodo(int id) {
		/*Iterator<Todo> iterator = todos.iterator();
		while (iterator.hasNext()) {
			Todo todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			}
		}*/
		tjt.delete(id);
	}
	
	
}