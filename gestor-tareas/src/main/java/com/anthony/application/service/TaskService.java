package com.anthony.application.service;

import com.anthony.application.dto.TaskDTO;
import com.anthony.domain.model.Task;
import com.anthony.domain.repository.TaskRepository;
import com.anthony.shared.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {


    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) { // ✅ Inyección por Constructor
        this.taskRepository = taskRepository;
    }

    public List<TaskDTO> getAllTasks() {
        return TaskMapper.toTaskDTOList(taskRepository.findAll());
    }

    public Optional<TaskDTO> getTaskById(Long id) {
        return taskRepository.findById(id).map(TaskMapper::toTaskDTO);
    }

    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = TaskMapper.toTask(taskDTO);
        return TaskMapper.toTaskDTO(taskRepository.save(task));
    }

    public TaskDTO updateTask(Long id, TaskDTO updatedTaskDTO) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(updatedTaskDTO.getTitle());
                    task.setDescription(updatedTaskDTO.getDescription());
                    task.setPriority(updatedTaskDTO.getPriority());
                    task.setStatus(updatedTaskDTO.getStatus());
                    return TaskMapper.toTaskDTO(taskRepository.save(task));
                })
                .orElse(null);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    // Nuevo método: Obtener tareas por estado
    public List<TaskDTO> getTasksByStatus(Task.Status status) {
        return TaskMapper.toTaskDTOList(taskRepository.findByStatus(status));
    }

    // Nuevo método: Obtener tareas que contengan cierto título
    public List<TaskDTO> getTasksByTitle(String title) {
        return TaskMapper.toTaskDTOList(taskRepository.findByTitleContainingIgnoreCase(title));
    }

    //Nuevo metodo: Encontrar por prioridad
    public List<TaskDTO> getTasksByPriority(Task.Priority priority) {
        return TaskMapper.toTaskDTOList(taskRepository.findByPriority(priority));
    }

    //Nuevo metodo: Eliminar tarea por id y devolver lista actualizada
    public List<TaskDTO> deleteTaskb(Long id) {
        taskRepository.deleteById(id);
        return TaskMapper.toTaskDTOList(taskRepository.findAll()); // ✅ Devuelve lista actualizada
    }
}
