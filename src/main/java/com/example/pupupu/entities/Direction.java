package com.example.pupupu.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "direction")
public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
