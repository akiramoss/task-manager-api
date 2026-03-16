package com.taskmanager.task_api.service;

import com.taskmanager.task_api.model.User;
import com.taskmanager.task_api.model.Task;
import com.taskmanager.task_api.repository.UserRepository;
import com.taskmanager.task_api.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service responsible for task business logic.
 */
@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    /**
     * Create a task for a specific user.
     */
    public Task createTask(Long userId, Task task) {

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        task.setUser(user);

        return taskRepository.save(task);
    }

    /**
     * Retrieve all tasks.
     */
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }
}
