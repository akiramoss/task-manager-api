package com.taskmanager.task_api.controller;


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
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    /**
     * Get all users
     * GET /users
     */
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getUsers();
    }
}
