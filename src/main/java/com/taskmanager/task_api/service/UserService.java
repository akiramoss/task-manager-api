package com.taskmanager.task_api.service;

import com.taskmanager.task_api.dto.UserCreateDTO;
import com.taskmanager.task_api.dto.UserResponseDTO;
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

    /**
     * Constructor injection of repository.
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Create a new user.
     */
    public UserResponseDTO createUser(UserCreateDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());

        User saved = userRepository.save(user);

        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setId(saved.getId());
        responseDTO.setName(saved.getName());
        responseDTO.setEmail(saved.getEmail());

        return responseDTO;
    }

    /**
     * Retrieve all users.
     */
    public List<UserResponseDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> {
                    UserResponseDTO responseDTO = new UserResponseDTO();
                    responseDTO.setId(user.getId());
                    responseDTO.setName(user.getName());
                    responseDTO.setEmail(user.getEmail());
                    return responseDTO;
                })
                .toList();
    }
}
