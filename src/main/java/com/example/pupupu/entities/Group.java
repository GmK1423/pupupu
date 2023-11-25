package com.example.pupupu.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity
@Data
@Table(name = "\"group\"")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "direction_id")
    private Direction directionId;
    private String name;

    @ManyToMany
    @JoinTable(name = "group_test",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "test_id"))
    private Collection<Test> tests;
}
