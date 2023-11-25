package com.example.pupupu.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity
@Data
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String topic;
    private String status;


    @ManyToMany
    @JoinTable(name = "test_task",
            joinColumns = @JoinColumn(name = "test_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private Collection<Task> tasks;

    @ManyToMany
    @JoinTable(name = "group_test",
            joinColumns = @JoinColumn(name = "test_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Collection<Group> groups;
}
