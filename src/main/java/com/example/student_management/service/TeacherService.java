package com.example.student_management.service;

import com.example.student_management.dto.BatchSaveDTO;
import com.example.student_management.dto.TeacherDTO;
import com.example.student_management.dto.TeacherSaveDTO;
import com.example.student_management.dto.TeacherUpdateDTO;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface TeacherService {
    TeacherDTO addTeacher(TeacherSaveDTO teacherSaveDTO);

    List<TeacherDTO> getAllTeachers();

    TeacherDTO updateTeacher(int id, TeacherUpdateDTO teacherUpdateDTO);

    void deleteTeacher(int id);
}
