package com.taskmanager.task_api.repository;

import com.taskmanager.task_api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository responsible for database access for Task entity.
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

}
