package com.taskmanager.task_api.service;

import com.taskmanager.task_api.dto.TaskCreateDTO;
import com.taskmanager.task_api.dto.TaskResponseDTO;
import com.taskmanager.task_api.exception.ResourceNotFoundException;
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
    public TaskResponseDTO createTask(TaskCreateDTO taskDTO) {

        User user = userRepository.findById(taskDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setCompleted(taskDTO.isCompleted());
        task.setUser(user);

        Task saved = taskRepository.save(task);

        TaskResponseDTO responseDTO = new TaskResponseDTO();
        responseDTO.setId(saved.getId());
        responseDTO.setTitle(saved.getTitle());
        responseDTO.setDescription(saved.getDescription());
        responseDTO.setCompleted(saved.isCompleted());
        responseDTO.setUserId(saved.getUser().getId());

        return responseDTO;
    }

    /**
     * Retrieve all tasks.
     */
    public List<TaskResponseDTO> getTasks() {
        return taskRepository.findAll()
                .stream()
                .map(task -> {
                    TaskResponseDTO responseDTO = new TaskResponseDTO();
                    responseDTO.setId(task.getId());
                    responseDTO.setTitle(task.getTitle());
                    responseDTO.setDescription(task.getDescription());
                    responseDTO.setCompleted(task.isCompleted());
                    responseDTO.setUserId(task.getUser().getId());
                    return responseDTO;
                })
                .toList();
    }
}
