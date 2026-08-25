package com.example.student_management.mapper;

import com.example.student_management.dto.StudentDTO;
import com.example.student_management.dto.StudentSaveDTO;
import com.example.student_management.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentDTO toDTO(Student student) {
        if(student == null) return null;
        return StudentDTO.builder()
                .studentId(student.getStudentId())
                .studentName(student.getStudentName())
                .address(student.getAddress())
                .phone(student.getPhone())
                .build();
    }

    public Student toEntity(StudentSaveDTO studentDTO) {
        if(studentDTO == null) return null;
        return Student.builder()
                .studentName(studentDTO.getStudentName())
                .address(studentDTO.getAddress())
                .phone(studentDTO.getPhone())
                .build();
    }
}
