package com.anthony.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Marca esta clase como una entidad de JPA y define la tabla asociada en la base de datos
@Entity
@Table(name = "tasks")

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Task {
    // Define el campo 'id' como la clave primaria y su valor se generará automáticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    // Define el enumerado 'Priority' con tres posibles valores
    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    public enum Status {
        PENDING, IN_PROGRESS, COMPLETED
    }


}
