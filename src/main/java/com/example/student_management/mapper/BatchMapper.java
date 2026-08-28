package com.example.student_management.mapper;

import com.example.student_management.dto.BatchDTO;
import com.example.student_management.dto.BatchSaveDTO;
import com.example.student_management.entity.Batch;
import com.example.student_management.entity.Course;

public class BatchMapper {
    public BatchDTO toDTO(Batch batch) {
        if(batch == null) return null;
        return BatchDTO.builder()
                .batchName(batch.getBatchName())
                .courseId(batch.getCourse() != null ? batch.getCourse().getCourseId() : 0)
                .startDate(batch.getStartDate())
                .batchId(batch.getBatchId())
                .build();
    }

    public Batch toEntity(BatchSaveDTO batchSaveDTO) {
        Course course = new Course();
        course.getCourseId();
        if(batchSaveDTO == null) return null;
        return Batch.builder()
                .batchName(batchSaveDTO.getBatchName())
                .startDate(batchSaveDTO.getStartDate())
                .course(course)
                .build();
    }
}
