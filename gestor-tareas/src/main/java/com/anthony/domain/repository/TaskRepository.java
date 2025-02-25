package com.anthony.domain.repository;

import com.anthony.domain.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//permite realizar operaciones en la base de datos para la entidad Task de manera sencilla
//Usando Spring Data JPA
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Buscar tareas por estado
    List<Task> findByStatus(Task.Status status);

    // Buscar tareas por prioridad
    List<Task> findByPriority(Task.Priority priority);

    // Buscar tareas que contengan cierta palabra clave en el título
    List<Task> findByTitleContainingIgnoreCase(String title);



}
