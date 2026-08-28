package com.example.student_management.service.impl;

import com.example.student_management.dto.TeacherDTO;
import com.example.student_management.dto.TeacherSaveDTO;
import com.example.student_management.dto.TeacherUpdateDTO;
import com.example.student_management.entity.Teacher;
import com.example.student_management.exception.ResourceException;
import com.example.student_management.mapper.TeacherMapper;
import com.example.student_management.repository.TeacherRepo;
import com.example.student_management.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
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
    public TeacherDTO updateTeacher(int id, TeacherUpdateDTO teacherUpdateDTO) {
        Teacher existingTeacher = teacherRepo.findById(id)
                .orElseThrow(() -> new ResourceException("Teacher not found by id" + id));
        existingTeacher.setTeacherName(teacherUpdateDTO.getTeacherName());
        existingTeacher.setAddress(teacherUpdateDTO.getAddress());
        existingTeacher.setPhone(teacherUpdateDTO.getPhone());
        Teacher saveTeacher = teacherRepo.save(existingTeacher);
        return teacherMapper.toDTO(saveTeacher);
    }

    @Override
    public void deleteTeacher(int id) {
        Teacher teacher = teacherRepo.findById(id)
                .orElseThrow(() -> new ResourceException("Teacher not found by id" + id));
        teacherRepo.delete(teacher);
    }
}
