import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from '../models/task.model';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  private apiUrl = 'http://localhost:8080/api/v1/tasks';

  constructor(private http: HttpClient) { }

  getTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(this.apiUrl).pipe(
      map(tasks => tasks.map(task => ({
        ...task,
        dueDate: new Date(task.date)
      })))
    );
  }

  getTask(id: number): Observable<Task> {
    return this.http.get<Task>(`${this.apiUrl}/${id}`).pipe(
      map(task => ({
        ...task,
        dueDate: new Date(task.date)
      }))
    );
  }

  addTask(task: Task): Observable<Task> {
    return this.http.post<Task>(this.apiUrl, task).pipe(
      map(newTask => ({
        ...newTask,
        dueDate: new Date(newTask.date)
      }))
    );
  }

  updateTask(task: Task): Observable<Task> {
    return this.http.put<Task>(this.apiUrl, task).pipe(
      map(updatedTask => ({
        ...updatedTask,
        dueDate: new Date(updatedTask.date)
      }))
    );
  }

  deleteTask(task: Task): Observable<Task> {
    return this.http.delete<Task>(this.apiUrl, { body: task });
  }
}

