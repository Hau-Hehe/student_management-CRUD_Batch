package com.example.student_management.service.impl;

import com.example.student_management.dto.CourseDTO;
import com.example.student_management.dto.CourseSaveDTO;
import com.example.student_management.dto.CourseUpdateDTO;
import com.example.student_management.entity.Course;
import com.example.student_management.exception.ResourceException;
import com.example.student_management.mapper.CourseMapper;
import com.example.student_management.repository.CourseRepo;
import com.example.student_management.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;
    private final CourseMapper courseMapper;

    @Override
    public CourseDTO addCourse(CourseSaveDTO courseSaveDTO) {
        Course course = courseMapper.toEntity(courseSaveDTO);
        Course saveCourse = courseRepo.save(course);
        return courseMapper.toDTO(saveCourse);
    }

    @Override
    public List<CourseDTO> getAllCourse() {
        return courseRepo.findAll()
                .stream()
                .map(courseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO updateCourse(int id, CourseUpdateDTO courseUpdateDTO) {
        Course existingCourse = courseRepo.findById(id)
                .orElseThrow(() -> new ResourceException("Course not found by id" + id));
        existingCourse.setCourseName(courseUpdateDTO.getCourseName());
        existingCourse.setSyllabus(courseUpdateDTO.getSyllabus());
        existingCourse.setDuration(courseUpdateDTO.getDuration());

        Course saveCourse = courseRepo.save(existingCourse);
        return courseMapper.toDTO(saveCourse);
    }

    @Override
    public void deleteCourse(int id) {
        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new ResourceException("Course not found by id" + id));
        courseRepo.delete(course);
    }
}
