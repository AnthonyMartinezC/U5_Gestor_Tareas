package com.anthony.infraestructure.persistence;

import com.anthony.domain.model.Task;
import com.anthony.domain.repository.TaskRepository;
import org.springframework.stereotype.Repository;

//Implementación concreta de persistencia con JPA

@Repository

public class TaskRepositoryImplement {
    //Inyección de dependencias de la interfaz TaskRepository
    private final TaskRepository taskRepository;

    //Constructor de la clase
    public TaskRepositoryImplement(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Guarda una tarea en la base de datos
    public Task save(Task task) {
        return taskRepository.save(task);
    }


    // Elimina una tarea de la base de datos usando su ID
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    //
}
