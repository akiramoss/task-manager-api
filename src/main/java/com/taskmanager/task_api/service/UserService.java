package com.taskmanager.task_api.service;

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
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Retrieve all users.
     */
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
