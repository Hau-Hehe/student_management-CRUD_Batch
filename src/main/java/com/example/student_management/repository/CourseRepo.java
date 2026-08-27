package com.example.student_management.repository;

import com.example.student_management.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.w3c.dom.css.Counter;

public interface CourseRepo extends JpaRepository<Course, Integer> {
}
