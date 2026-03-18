package com.taskmanager.task_api.service;

import com.taskmanager.task_api.dto.TaskCreateDTO;
import com.taskmanager.task_api.dto.TaskResponseDTO;
import com.taskmanager.task_api.mapper.TaskMapper;
import com.taskmanager.task_api.model.Task;
import com.taskmanager.task_api.model.User;
import com.taskmanager.task_api.repository.TaskRepository;
import com.taskmanager.task_api.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    @Test
    void shouldCreateTaskSuccessfully() {

        // Mocks
        TaskRepository taskRepository = Mockito.mock(TaskRepository.class);
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        TaskMapper taskMapper = Mockito.mock(TaskMapper.class);

        TaskService service = new TaskService(taskRepository, userRepository, taskMapper);

        // Input DTO
        TaskCreateDTO dto = new TaskCreateDTO();
        dto.setTitle("Test Task");
        dto.setUserId(1L);

        // Mock User
        User user = new User();
        user.setId(1L);

        Mockito.when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));

        // Mock Task
        Task task = new Task();
        task.setTitle("Test Task");

        Mockito.when(taskMapper.toEntity(dto)).thenReturn(task);
        Mockito.when(taskRepository.save(task)).thenReturn(task);

        TaskResponseDTO response = new TaskResponseDTO();
        response.setTitle("Test Task");

        Mockito.when(taskMapper.toDTO(task)).thenReturn(response);

        // Execute
        TaskResponseDTO result = service.createTask(dto);

        // Assertions
        assertNotNull(result);
        assertEquals("Test Task", result.getTitle());
    }

    @Test
    void shouldThrowExceptionWhenUserNotFound() {

        TaskRepository taskRepository = Mockito.mock(TaskRepository.class);
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        TaskMapper taskMapper = Mockito.mock(TaskMapper.class);

        TaskService service = new TaskService(taskRepository, userRepository, taskMapper);

        TaskCreateDTO dto = new TaskCreateDTO();
        dto.setUserId(99L);

        Mockito.when(userRepository.findById(99L))
                .thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> service.createTask(dto));
    }

    @Test
    void shouldReturnListOfTasks() {

        TaskRepository taskRepository = Mockito.mock(TaskRepository.class);
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        TaskMapper taskMapper = Mockito.mock(TaskMapper.class);

        TaskService service = new TaskService(taskRepository, userRepository, taskMapper);

        // Mock data
        Task task = new Task();
        task.setTitle("Task 1");

        Mockito.when(taskRepository.findAll())
                .thenReturn(List.of(task));

        TaskResponseDTO dto = new TaskResponseDTO();
        dto.setTitle("Task 1");

        Mockito.when(taskMapper.toDTO(task)).thenReturn(dto);

        // Execute
        List<TaskResponseDTO> result = service.getTasks();

        // Assert
        assertEquals(1, result.size());
        assertEquals("Task 1", result.get(0).getTitle());
    }

    @Test
    void shouldReturnEmptyListWhenNoTasks() {

        TaskRepository taskRepository = Mockito.mock(TaskRepository.class);
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        TaskMapper taskMapper = Mockito.mock(TaskMapper.class);

        TaskService service = new TaskService(taskRepository, userRepository, taskMapper);

        Mockito.when(taskRepository.findAll())
                .thenReturn(List.of());

        List<TaskResponseDTO> result = service.getTasks();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}
