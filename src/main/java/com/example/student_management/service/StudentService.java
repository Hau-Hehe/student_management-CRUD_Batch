package com.example.student_management.service;

import com.example.student_management.dto.*;

import java.util.List;

public interface StudentService {
    StudentDTO addStudent(StudentSaveDTO studentSaveDTO);

    List<StudentDTO> getAllStudents();

    StudentDTO updateStudent(int id, StudentUpdateDTO studentUpdateDTO);

    void deleteStudent(int id);
}
