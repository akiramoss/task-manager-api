package com.taskmanager.task_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Entity representing a user of the system.
 * A user can own multiple tasks.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    /**
     * Primary key of the user.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Name of the user.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Email of the user.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Relationship: one user can have many tasks.
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;

    public User(){

    }
}
