package com.taskmanager.task_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a task.
 */
@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {

    /**
     * Primary key of the task.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Title of the task.
     */
    @Column(nullable = false)
    private String title;

    /**
     * Description of the task.
     */
    private String description;

    /**
     * Indicates if the task is completed.
     */
    private boolean completed;

    /**
     * Many tasks belong to one user.
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Task() {

    }
}
