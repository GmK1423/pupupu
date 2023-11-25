package com.example.pupupu.entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "response")
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
    private String value;
    private Boolean status;

}
