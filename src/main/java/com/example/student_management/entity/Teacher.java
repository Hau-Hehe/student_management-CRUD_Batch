package com.example.student_management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "teachers")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacher_id", length = 11)
    private int teacherId;

    @Column(name = "teacher_name", length = 45)
    private String teacherName;

    @Column(name = "addess", length = 60)
    private String address;

    @Column(name = "phone", length = 10)
    private String phone;
}
