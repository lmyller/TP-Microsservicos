package com.rest.task.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rest.task.entity.Task;
import com.rest.task.service.TaskService;

@CrossOrigin(origins = "http://localhost:4200/")
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/v1")
public class TaskController {
	TaskService taskService;

	@Autowired
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping("/tasks")
	public List<Task> findAll(){
		return taskService.findAll();
	}
	
	@GetMapping("/tasks/{taskId}")
	public Task getTask(@PathVariable Long taskId) {
		try {
			return taskService.findById(taskId);
		} catch (NoSuchElementException noSuchElementException) {
			throw new RuntimeException("Tarefa não registrada");
		}
	}
	
	@PostMapping("/tasks")
	public Task addTask(@RequestBody Task task) {
		return taskService.save(task);
	}
	
	@PutMapping("/tasks")
	public Task updateTask(@RequestBody Task task) {
		return taskService.save(task);
	}
	
	@DeleteMapping("/tasks")
	public Task deleteTask(@RequestBody Task task) {
		return taskService.delete(task);
	}
}
