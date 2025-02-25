package com.anthony.application.dto;


import com.anthony.domain.model.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TaskDTO {
        private Long id;
        private String title;
        private String description;
        private Task.Priority priority;
        private Task.Status status;


}
