package com.example.student_management.controller;

import com.example.student_management.dto.StudentDTO;
import com.example.student_management.dto.StudentSaveDTO;
import com.example.student_management.dto.TeacherDTO;
import com.example.student_management.dto.TeacherSaveDTO;
import com.example.student_management.service.StudentService;
import com.example.student_management.service.TeacherService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/save")
    public ResponseEntity<TeacherDTO> saveTeacher(@RequestBody TeacherSaveDTO teacherSaveDTO){
        return new ResponseEntity<>(teacherService.addTeacher(teacherSaveDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getAllTeachers")
    public ResponseEntity<List<TeacherDTO>> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @PutMapping("/updateTeacher/{id}")
    public ResponseEntity<TeacherDTO> updateTeacher(@PathVariable int id, @RequestBody TeacherSaveDTO teacherSaveDTO) {
        return ResponseEntity.ok(teacherService.updateTeacher(id, teacherSaveDTO));
    }

    @DeleteMapping("/deleteTeacher/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable int id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.ok("Delete successfully");
    }
}
