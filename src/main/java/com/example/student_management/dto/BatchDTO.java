package com.example.student_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BatchDTO {
    private int batchId;
    private String batchName;
    private int courseId;
    private String startDate;
}
