package com.example.student_management.controller;

import com.example.student_management.dto.*;
import com.example.student_management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/save")
    public ResponseEntity<CourseDTO> saveCourse(@RequestBody CourseSaveDTO courseSaveDTO){
        return new ResponseEntity<>(courseService.addCourse(courseSaveDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getAllCourses")
    public ResponseEntity<List<CourseDTO>> getAllCourseDTO() {
        return ResponseEntity.ok(courseService.getAllCourse());
    }

    @PutMapping("/updateCourse/{id}")
    public ResponseEntity<CourseDTO> updateCourse(@PathVariable int id, @RequestBody CourseUpdateDTO courseUpdateDTO) {
        return ResponseEntity.ok(courseService.updateCourse(id, courseUpdateDTO));
    }

    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Delete successfully");
    }
}
