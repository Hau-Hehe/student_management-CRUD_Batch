package com.example.student_management.controller;


import com.example.student_management.dto.StudentDTO;
import com.example.student_management.dto.StudentSaveDTO;
import com.example.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentSaveDTO studentSaveDTO){
        return new ResponseEntity<>(studentService.addStudent(studentSaveDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable int id, @RequestBody StudentSaveDTO studentSaveDTO) {
        return ResponseEntity.ok(studentService.updateStudent(id, studentSaveDTO));
    }
}
