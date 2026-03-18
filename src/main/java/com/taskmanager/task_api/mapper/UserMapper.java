package com.taskmanager.task_api.mapper;

import com.taskmanager.task_api.dto.UserCreateDTO;
import com.taskmanager.task_api.dto.UserResponseDTO;
import com.taskmanager.task_api.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
// Spring injection
public interface UserMapper {

    User toEntity(UserCreateDTO dto);

    UserResponseDTO toDTO(User user);
}