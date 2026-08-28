package com.example.student_management.service.impl;

import com.example.student_management.dto.BatchDTO;
import com.example.student_management.dto.BatchSaveDTO;
import com.example.student_management.dto.BatchUpdateDTO;
import com.example.student_management.service.BatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BatchServiceImpl implements BatchService {

    private final BatchService batchService;
    @Override
    public BatchDTO addCourse(BatchSaveDTO batchSaveDTO) {
        return null;
    }

    @Override
    public List<BatchDTO> getAllBatches() {
        return List.of();
    }

    @Override
    public BatchDTO updateCourse(int id, BatchUpdateDTO batchUpdateDTO) {
        return null;
    }

    @Override
    public void deleteBatch(int id) {

    }
}
