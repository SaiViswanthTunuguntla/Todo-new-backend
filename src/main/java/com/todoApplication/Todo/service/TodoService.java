package com.todoApplication.Todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoApplication.Todo.Repository.TodoRepository;
import com.todoApplication.Todo.model.Todo;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepo;
	
	public List<Todo> getAllTodos() {
		return todoRepo.getAllTodos();
	}

	public Todo getById(int id) {
		return todoRepo.getById(id);
	}

	public Todo save(Todo todo) {
		Todo todo2 = todoRepo.save(todo);
		return todo2;
	}

	public Todo save(Todo todo, int id) {
		Todo savedTodo = todoRepo.save(id,todo);
		return savedTodo;
	}

	public boolean deleteById(int id) {
		return todoRepo.deleteById(id);
	}

}
