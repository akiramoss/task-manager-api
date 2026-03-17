package com.taskmanager.task_api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO used to create a new user.
 */
@Getter
@Setter
public class UserCreateDTO {

    private String name;
    private String email;
}
