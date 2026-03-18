package com.taskmanager.task_api.service;

import com.taskmanager.task_api.dto.TaskCreateDTO;
import com.taskmanager.task_api.dto.TaskResponseDTO;
import com.taskmanager.task_api.exception.ResourceNotFoundException;
import com.taskmanager.task_api.mapper.TaskMapper;
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
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.taskMapper = taskMapper;
    }

    public TaskResponseDTO createTask(TaskCreateDTO taskDTO) {

        User user = userRepository.findById(taskDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Task task = taskMapper.toEntity(taskDTO);
        task.setUser(user);
        Task saved = taskRepository.save(task);

        return taskMapper.toDTO(saved);
    }

    /**
     * Retrieve all tasks.
     */
    public List<TaskResponseDTO> getTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toDTO)
                .toList();
    }
}
