package com.example.student_management.service;

import com.example.student_management.dto.StudentDTO;
import com.example.student_management.dto.StudentSaveDTO;
import com.example.student_management.dto.TeacherDTO;
import com.example.student_management.dto.TeacherSaveDTO;

import java.util.List;

public interface StudentService {
    StudentDTO addStudent(StudentSaveDTO studentSaveDTO);

    List<StudentDTO> getAllStudents();

    StudentDTO updateStudent(int id, StudentSaveDTO studentSaveDTO);

    void deleteStudent(int id);
}
