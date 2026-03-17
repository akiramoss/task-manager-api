package com.taskmanager.task_api.controller;

import com.taskmanager.task_api.dto.TaskCreateDTO;
import com.taskmanager.task_api.dto.TaskResponseDTO;
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
    public TaskResponseDTO createTask(@RequestBody TaskCreateDTO taskDTO) {
        return taskService.createTask(taskDTO);
    }

    /**
     * Get all tasks
     * GET /tasks
     */
    @GetMapping
    public List<TaskResponseDTO> getTasks() {
        return taskService.getTasks();
    }
}
