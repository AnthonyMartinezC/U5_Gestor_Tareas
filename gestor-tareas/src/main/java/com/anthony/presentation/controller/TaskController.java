package com.anthony.presentation.controller;

import com.anthony.application.dto.TaskDTO;
import com.anthony.application.service.TaskService;
import com.anthony.domain.model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {


    private final TaskService taskService;

    public TaskController(TaskService taskService) { // ✅ Inyección por Constructor
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskDTO> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Optional<TaskDTO> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    public TaskDTO createTask(@RequestBody TaskDTO taskDTO) {
        return taskService.createTask(taskDTO);
    }

    @PutMapping("/{id}")
    public TaskDTO updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        return taskService.updateTask(id, taskDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTaskb(id);
    }

    // Nuevo Endpoint: Buscar tareas por estado
    @GetMapping("/status/{status}")
    public List<TaskDTO> getTasksByStatus(@PathVariable Task.Status status) {
        return taskService.getTasksByStatus(status);
    }

    // Nuevo Endpoint: Buscar tareas por título parcial
    @GetMapping("/search")
    public List<TaskDTO> getTasksByTitle(@RequestParam String title) {
        return taskService.getTasksByTitle(title);
    }

}
