package com.example.student_management.controller;

import com.example.student_management.dto.*;
import com.example.student_management.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/batch")
public class BatchController {

    @Autowired
    private BatchService batchService;

    @PostMapping("/save")
    public ResponseEntity<BatchDTO> saveBatch(@RequestBody BatchSaveDTO batchSaveDTO){
        return new ResponseEntity<>(batchService.addCourse(batchSaveDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getAllBatches")
    public ResponseEntity<List<BatchDTO>> getAllBatches() {
        return ResponseEntity.ok(batchService.getAllBatches());
    }

    @PutMapping("/updateBatch/{id}")
    public ResponseEntity<BatchDTO> updateBatch(@PathVariable int id, @RequestBody BatchUpdateDTO batchUpdateDTO) {
        return ResponseEntity.ok(batchService.updateCourse(id, batchUpdateDTO));
    }

    @DeleteMapping("/deleteBatch/{id}")
    public ResponseEntity<String> deleteBatch(@PathVariable int id) {
        batchService.deleteBatch(id);
        return ResponseEntity.ok("Delete successfully");
    }
}
