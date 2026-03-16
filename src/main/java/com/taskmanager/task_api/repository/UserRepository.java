package com.taskmanager.task_api.repository;

import com.taskmanager.task_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository responsible for database access for User entity.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    // Spring automáticamente genera las opreraciones CRUD
}
