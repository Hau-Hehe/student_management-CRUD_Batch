package com.example.student_management.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TeacherUpdateDTO {
    private int teacherId;
    private String teacherName;
    private String address;
    private String phone;
}
