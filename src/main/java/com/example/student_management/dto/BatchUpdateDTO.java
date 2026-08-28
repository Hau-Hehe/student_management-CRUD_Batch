package com.example.student_management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BatchUpdateDTO {
    private int batchId;
    private String batchName;
    private String courseId;
    private String startDate;
}
