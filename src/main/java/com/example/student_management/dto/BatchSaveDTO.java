package com.example.student_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BatchSaveDTO {
    private String batchName;
    private String courseId;
    private String startDate;
}
