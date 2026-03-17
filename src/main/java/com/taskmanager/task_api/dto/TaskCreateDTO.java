package com.taskmanager.task_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO used to create a new task.
 */
@Getter
@Setter
public class TaskCreateDTO {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    private boolean completed;

    @NotNull(message = "UserId is required")
    private Long userId;
}
