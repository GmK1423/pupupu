package com.example.pupupu.repositories;

import com.example.pupupu.entities.Direction;
import com.example.pupupu.entities.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DirectionRepository extends JpaRepository<Direction,Long> {
    Optional<Direction> findByName(String name);
}
