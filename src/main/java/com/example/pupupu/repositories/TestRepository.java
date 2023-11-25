package com.example.pupupu.repositories;

import com.example.pupupu.entities.Task;
import com.example.pupupu.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test,Long>{
}
