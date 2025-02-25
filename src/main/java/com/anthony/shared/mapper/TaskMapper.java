package com.anthony.shared.mapper;

import com.anthony.application.dto.TaskDTO;
import com.anthony.domain.model.Task;

import java.util.List;
import java.util.stream.Collectors;

public class TaskMapper {


    public static TaskDTO toTaskDTO(Task task) {
        return new TaskDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getPriority(),
                task.getStatus()
        );
    }

    public static Task toTask(TaskDTO taskDTO) {
        return new Task(
                taskDTO.getId(),
                taskDTO.getTitle(),
                taskDTO.getDescription(),
                taskDTO.getPriority(),
                taskDTO.getStatus()
        );
    }

    public static List<TaskDTO> toTaskDTOList(List<Task> tasks) {
        return tasks.stream().map(TaskMapper::toTaskDTO).collect(Collectors.toList());
    }
}
