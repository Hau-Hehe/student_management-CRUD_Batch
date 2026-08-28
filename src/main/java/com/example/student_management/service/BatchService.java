package com.example.student_management.service;

import com.example.student_management.dto.BatchDTO;
import com.example.student_management.dto.BatchSaveDTO;
import com.example.student_management.dto.BatchUpdateDTO;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface BatchService {
    BatchDTO addCourse(BatchSaveDTO batchSaveDTO);

    List<BatchDTO> getAllBatches();

    BatchDTO updateCourse(int id, BatchUpdateDTO batchUpdateDTO);

    void deleteBatch(int id);
}
