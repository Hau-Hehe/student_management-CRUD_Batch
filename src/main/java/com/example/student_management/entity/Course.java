package com.example.student_management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RequiredArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id", length = 11)
    private int courseId;

    @NonNull
    @Column(name = "course_name", length = 45)
    private String courseName;

    @NonNull
    @Column(name = "syllabus", length = 60)
    private String syllabus;

    @NonNull
    @Column(name = "duration", length = 10)
    private String duration;
}
