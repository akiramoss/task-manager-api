package com.taskmanager.task_api.service;

import com.taskmanager.task_api.dto.UserCreateDTO;
import com.taskmanager.task_api.dto.UserResponseDTO;
import com.taskmanager.task_api.mapper.UserMapper;
import com.taskmanager.task_api.model.User;
import com.taskmanager.task_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service responsible for user business logic.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    /**
     * Constructor injection of repository.
     */
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    /**
     * Create a new user.
     */
    public UserResponseDTO createUser(UserCreateDTO userDTO) {

        User user = userMapper.toEntity(userDTO);
        User saved = userRepository.save(user);

        return userMapper.toDTO(saved);
    }

    /**
     * Retrieve all users.
     */
    public List<UserResponseDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .toList();
    }
}
