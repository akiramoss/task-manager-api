package com.taskmanager.task_api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO used to create a new task.
 */
@Getter
@Setter
public class TaskCreateDTO {

    private String title;
    private String description;
    private boolean completed;

    private Long userId;
}
