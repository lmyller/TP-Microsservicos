package com.rest.task.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.task.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{}
