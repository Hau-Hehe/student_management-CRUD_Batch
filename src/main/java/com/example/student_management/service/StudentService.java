package com.example.student_management.service;

import com.example.student_management.dto.StudentDTO;
import com.example.student_management.dto.StudentSaveDTO;

import java.util.List;

public interface StudentService {
    StudentDTO addStudent(StudentSaveDTO studentSaveDTO);

    List<StudentDTO> getAllStudents();

    StudentDTO updateStudent(int id, StudentSaveDTO studentSaveDTO);
}
