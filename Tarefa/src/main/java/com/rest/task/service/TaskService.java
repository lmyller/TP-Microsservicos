package com.rest.task.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;

import com.rest.task.dao.TaskRepository;
import com.rest.task.entity.Task;

@org.springframework.stereotype.Service
public class TaskService implements Service<Task> {

	TaskRepository taskRepository;
	
	@Autowired
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@Override
	public Task save(Task entity) {
		return taskRepository.save(entity);
	}

	@Override
	public Task findById(Long id) throws NoSuchElementException {
		return taskRepository.findById(id).get();
	}

	@Override
	public List<Task> findAll() {
		return taskRepository.findAll();
	}

	@Override
	public Task delete(Task entity) {
		taskRepository.delete(entity);
		return entity;
	}
}
