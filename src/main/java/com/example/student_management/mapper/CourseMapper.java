package com.example.student_management.mapper;

import com.example.student_management.dto.CourseDTO;
import com.example.student_management.dto.CourseSaveDTO;
import com.example.student_management.entity.Course;

public class CourseMapper {
    public CourseDTO toDTO(Course course) {
        if(course == null) return null;
        return CourseDTO.builder()
                .courseId(course.getCourseId())
                .courseName(course.getCourseName())
                .syllabus(course.getSyllabus())
                .duration(course.getDuration())
                .build();
    }

    public Course toEntity(CourseSaveDTO courseSaveDTO) {
        if(courseSaveDTO == null) return null;
        return Course.builder()
                .courseId(courseSaveDTO.getCourseId())
                .courseName(courseSaveDTO.getCourseName())
                .syllabus(courseSaveDTO.getSyllabus())
                .duration(courseSaveDTO.getDuration())
                .build();
    }
}
