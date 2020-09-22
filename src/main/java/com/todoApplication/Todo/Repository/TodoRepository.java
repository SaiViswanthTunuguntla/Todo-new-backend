package com.todoApplication.Todo.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.todoApplication.Todo.model.Todo;

@Repository
public class TodoRepository {

	private static List<Todo> todoList=new ArrayList<>();
	private static int id=1;
	
	static {
		todoList.add(new Todo("Full Stack Application",id++,false));
		todoList.add(new Todo("Back end Java+Spring",id++,false));
		todoList.add(new Todo("Front Angular",id++,false));
		todoList.add(new Todo("Full Stack Application2",id++,false));
		todoList.add(new Todo("Full Stack Application3",id++,false));
	}
	
	public List<Todo> getAllTodos() {
		return todoList;
	}

	public Todo getById(int id2) {
		for(Todo todo:todoList)
		{
			if(todo.getId()==id2)
			{
				return todo;
			}
		}
		return null;
	}

	public Todo save(Todo todo) {
		
		todo.setId(id++);
		todoList.add(todo);
		return todo;
	}

	public Todo save(int id2, Todo todo) 
	{
		boolean isdeleted = deleteById(id2);
		if(isdeleted) todoList.add(todo);
		return todo;
		
	}
	public boolean deleteById(int id)
	{
		boolean isRemoved= false;
		Todo todo = getById(id);
		if(todo!=null) {
			 isRemoved = todoList.remove(todo);
		}
		return isRemoved;
	}

}
