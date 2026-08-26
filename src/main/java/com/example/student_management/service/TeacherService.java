package com.example.student_management.service;

import com.example.student_management.dto.TeacherDTO;
import com.example.student_management.dto.TeacherSaveDTO;

import java.util.List;

public interface TeacherService {
    TeacherDTO addTeacher(TeacherSaveDTO teacherSaveDTO);

    List<TeacherDTO> getAllTeachers();

    TeacherDTO updateTeacher(int id, TeacherSaveDTO teacherSaveDTO);

    void deleteTeacher(int id);
}
