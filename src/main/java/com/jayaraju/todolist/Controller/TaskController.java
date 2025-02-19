package com.jayaraju.todolist.Controller;

import com.jayaraju.todolist.entity.Task;
import com.jayaraju.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Get all tasks for a specific user
    @GetMapping
    public List<Task> getAllTasksByUserId(@RequestParam Long userId) {
    return taskService.getAllTasksByUserId(userId);
}

    // Create a new task for a user
    @PostMapping("/user/{userId}")
    public Task createTask(@RequestBody Task task, @PathVariable Long userId) {
        return taskService.createTask(task, userId);
    }

    // Update an existing task
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        return taskService.updateTask(id, updatedTask);
    }

    // Delete a task
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "Task deleted with id " + id;
    }
}
