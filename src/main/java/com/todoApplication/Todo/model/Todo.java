package com.todoApplication.Todo.model;

public class Todo {
	
	private String task;
	private int id;
	private boolean isDone;
	
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	
	public Todo(String task, int id, boolean isDone) {
		super();
		this.task = task;
		this.id = id;
		this.isDone = isDone;
	}
	@Override
	public String toString() {
		return "Todo [task=" + task + ", id=" + id + ", isDone=" + isDone + "]";
	}
	
	
	

}
