package com.rest.task.controller;

import java.util.List;
import java.util.NoSuchElementException;

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
	public ResponseEntity<List<Task>> findAll(){
		return ResponseEntity.ok(taskService.findAll());
	}
	
	@GetMapping("/tasks/{taskId}")
	public ResponseEntity<Task> getTask(@PathVariable Long taskId) {
		return ResponseEntity.ok(taskService.findById(taskId));
	}
	
	@PostMapping("/tasks")
	public ResponseEntity<Task> addTask(@RequestBody Task task) {
		 return ResponseEntity.ok(taskService.save(task));
	}
	
	@PutMapping("/tasks")
	public ResponseEntity<Task> updateTask(@RequestBody Task task) {
		return ResponseEntity.ok(taskService.save(task));
	}
	
	@DeleteMapping("/tasks")
	public ResponseEntity<Task> deleteTask(@RequestBody Task task) {
		return ResponseEntity.ok(taskService.delete(task));
	}
}
