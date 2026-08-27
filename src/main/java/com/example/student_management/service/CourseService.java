package com.example.student_management.service;

import com.example.student_management.dto.CourseDTO;
import com.example.student_management.dto.CourseSaveDTO;
import com.example.student_management.dto.CourseUpdateDTO;

import java.util.List;

public interface CourseService {
    CourseDTO addCourse(CourseSaveDTO courseSaveDTO);

    List<CourseDTO> getAllCourse();

    CourseDTO updateCourse(int id, CourseUpdateDTO courseUpdateDTO);

    void deleteCourse(int id);
}
