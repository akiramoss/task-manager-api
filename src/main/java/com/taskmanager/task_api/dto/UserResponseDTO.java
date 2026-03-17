package com.taskmanager.task_api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO used to return user data.
 */
@Getter
@Setter
public class UserResponseDTO {

    private Long id;
    private String name;
    private String email;
}
