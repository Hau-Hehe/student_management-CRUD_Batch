package com.example.student_management.service.impl;

import com.example.student_management.dto.TeacherDTO;
import com.example.student_management.dto.TeacherSaveDTO;
import com.example.student_management.entity.Teacher;
import com.example.student_management.exception.ResourceException;
import com.example.student_management.mapper.TeacherMapper;
import com.example.student_management.repository.TeacherRepo;
import com.example.student_management.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepo teacherRepo;
    private final TeacherMapper teacherMapper;

    @Override
    public TeacherDTO addTeacher(TeacherSaveDTO teacherSaveDTO) {
        Teacher teacher = teacherMapper.toEntity(teacherSaveDTO);
        Teacher savedTeacher = teacherRepo.save(teacher);
        return teacherMapper.toDTO(savedTeacher);
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        return teacherRepo.findAll()
                .stream()
                .map(teacherMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherDTO updateTeacher(int id, TeacherSaveDTO teacherSaveDTO) {
        Teacher existingTeacher = teacherRepo.findById(id)
                .orElseThrow(() -> new ResourceException("Teacher not found by id" + id));
        existingTeacher.setTeacherName(teacherSaveDTO.getTeacherName());
        existingTeacher.setAddress(teacherSaveDTO.getAddress());
        existingTeacher.setPhone(teacherSaveDTO.getPhone());
        return teacherMapper.toDTO(existingTeacher);
    }

    @Override
    public void deleteTeacher(int id) {
        Teacher teacher = teacherRepo.findById(id)
                .orElseThrow(() -> new ResourceException("Teacher not found by id" + id));
        teacherRepo.delete(teacher);
    }
}
