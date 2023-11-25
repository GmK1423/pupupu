package com.example.pupupu.repositories;


import com.example.pupupu.entities.Group;
import com.example.pupupu.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group,Long> {
    Optional<Group> findByName(String name);
}
