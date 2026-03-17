package com.taskmanager.task_api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO used to return task data.
 */
@Getter
@Setter
public class TaskResponseDTO {

    private Long id;
    private String title;
    private String description;
    private boolean completed;

    private Long userId;
}
