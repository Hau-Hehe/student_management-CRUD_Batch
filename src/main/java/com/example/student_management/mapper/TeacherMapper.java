package com.example.student_management.mapper;

import com.example.student_management.dto.TeacherDTO;
import com.example.student_management.dto.TeacherSaveDTO;
import com.example.student_management.entity.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {
    public TeacherDTO toDTO(Teacher teacher) {
        if(teacher == null) return null;
        return TeacherDTO.builder()
                .teacherId(teacher.getTeacherId())
                .teacherName(teacher.getTeacherName())
                .address(teacher.getAddress())
                .phone(teacher.getPhone())
                .build();
    }

    public Teacher toEntity(TeacherSaveDTO teacherSaveDTO) {
        if(teacherSaveDTO == null) return null;
        return Teacher.builder()
                .teacherName(teacherSaveDTO.getTeacherName())
                .address(teacherSaveDTO.getAddress())
                .phone(teacherSaveDTO.getPhone())
                .build();
    }
}
