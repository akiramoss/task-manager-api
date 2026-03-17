package com.taskmanager.task_api.controller;

import com.taskmanager.task_api.model.Task;
import com.taskmanager.task_api.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for task operations.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * Create task for a user
     * POST /tasks?userId=1
     */
    @PostMapping
    public Task createTask(
            @RequestParam Long userId,
            @RequestBody Task task
    ) {
        return taskService.createTask(userId, task);
    }

    /**
     * Get all tasks
     * GET /tasks
     */
    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }
}
