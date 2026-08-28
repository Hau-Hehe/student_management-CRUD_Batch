package com.example.student_management.repository;

import com.example.student_management.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BatchRepo extends JpaRepository<Batch, Integer> {
}
