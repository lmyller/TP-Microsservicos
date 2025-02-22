import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { TaskService } from '../services/task.service';
import { Task } from '../models/task.model';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  tasks: Task[] = [];
  newTask: Task = { name: '', description: '', completed: false, date: new Date() };
  editingTask: Task | null = null;

  constructor(private taskService: TaskService) { }

  ngOnInit(): void {
    this.loadTasks();
  }

  loadTasks(): void {
    this.taskService.getTasks().subscribe(
      (tasks) => this.tasks = tasks,
      (error) => console.error('Erro ao carregar tarefas:', error)
    );
  }

  addTask(): void {
    this.taskService.addTask(this.newTask).subscribe(
      (task) => {
        this.tasks.push(task);
        this.newTask = { name: '', description: '', completed: false, date: new Date() };
      },
      (error) => console.error('Erro ao adicionar tarefa:', error)
    );
  }

  startEditing(task: Task): void {
    this.editingTask = { ...task, date: new Date(task.date) };
  }

  updateTask(): void {
    if (this.editingTask) {
      this.taskService.updateTask(this.editingTask).subscribe(
        (updatedTask) => {
          const index = this.tasks.findIndex(t => t.id === updatedTask.id);
          if (index !== -1) {
            this.tasks[index] = updatedTask;
          }
          this.editingTask = null;
        },
        (error) => console.error('Erro ao atualizar tarefa:', error)
      );
    }
  }

  deleteTask(task: Task): void {
    this.taskService.deleteTask(task).subscribe(
      () => {
        this.tasks = this.tasks.filter(t => t.id !== task.id);
      },
      (error) => console.error('Erro ao excluir tarefa:', error)
    );
  }

  cancelEditing(): void {
    this.editingTask = null;
  }
}

