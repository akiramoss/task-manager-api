package com.taskmanager.task_api.mapper;

import com.taskmanager.task_api.dto.TaskCreateDTO;
import com.taskmanager.task_api.dto.TaskResponseDTO;
import com.taskmanager.task_api.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    /**
     * DTO → Entity
     */
    @Mapping(target = "user", ignore = true)
    Task toEntity(TaskCreateDTO dto);

    /**
     * Entity → DTO
     */
    @Mapping(source = "user.id", target = "userId")
    TaskResponseDTO toDTO(Task task);
}
