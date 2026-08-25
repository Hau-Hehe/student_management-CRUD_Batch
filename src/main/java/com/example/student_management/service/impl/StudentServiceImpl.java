package com.example.student_management.service.impl;

import com.example.student_management.dto.StudentDTO;
import com.example.student_management.dto.StudentSaveDTO;
import com.example.student_management.entity.Student;
import com.example.student_management.exception.ResourceException;
import com.example.student_management.mapper.StudentMapper;
import com.example.student_management.repository.StudentRepo;
import com.example.student_management.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    @Autowired
    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;

    @Override
    public StudentDTO addStudent(StudentSaveDTO studentSaveDTO) {
//        Student student = new Student(
//                studentSaveDTO.getStudentName(),
//                studentSaveDTO.getAddress(),
//                studentSaveDTO.getPhone()
//        );
//        studentRepo.save(student);
//
//        return student.getStudentName();
        Student student = studentMapper.toEntity(studentSaveDTO);
        Student savedStudent = studentRepo.save(student);
        return studentMapper.toDTO(savedStudent);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepo.findAll()
                .stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public StudentDTO updateStudent(int id, StudentSaveDTO studentSaveDTO) {
        Student existingStudent = studentRepo.findById(id)
                .orElseThrow(() -> new ResourceException("Student not found by id" + id));

        existingStudent.setStudentName(studentSaveDTO.getStudentName());
        existingStudent.setAddress(studentSaveDTO.getAddress());
        existingStudent.setPhone(studentSaveDTO.getPhone());

        Student updateStudent =  studentRepo.save(existingStudent);
        return studentMapper.toDTO(updateStudent);
    }
}
