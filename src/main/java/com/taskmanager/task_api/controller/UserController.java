package com.taskmanager.task_api.controller;


import com.taskmanager.task_api.dto.UserCreateDTO;
import com.taskmanager.task_api.dto.UserResponseDTO;
import com.taskmanager.task_api.model.User;
import com.taskmanager.task_api.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for user operations.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    /**
     * Constructor injection
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Create user
     * POST /users
     */
    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserCreateDTO userDTO) {
        return userService.createUser(userDTO);
    }

    /**
     * Get all users
     * GET /users
     */
    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return userService.getUsers();
    }
}
