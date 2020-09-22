package com.todoApplication.Todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todoApplication.Todo.model.Todo;
import com.todoApplication.Todo.service.TodoService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping("/todos")
	public List<Todo> getAllTodos()
	{
		return todoService.getAllTodos();
	}
	
	@GetMapping("/todos/{id}")
	public Todo getTodoById(@PathVariable int id)
	{
		return todoService.getById(id);
	}
	
	@PostMapping("/todos")
	public ResponseEntity<Todo> createTodo(@RequestBody Todo todo)
	{
		Todo savedTodo = todoService.save(todo);
		return new ResponseEntity<Todo>(savedTodo,HttpStatus.CREATED);
	}
	
	@PutMapping("/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable int id,@RequestBody Todo todo)
	{
		Todo savedTodo = todoService.save(todo,id);
		return new ResponseEntity<Todo>(savedTodo,HttpStatus.OK);
	}
	
	@DeleteMapping("/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable int id)
	{
		boolean isDeleted = todoService.deleteById(id);
		
		if(isDeleted)return new ResponseEntity<Void>(HttpStatus.OK);
		
		return new ResponseEntity<Void>( HttpStatus.BAD_REQUEST);
	}

}
