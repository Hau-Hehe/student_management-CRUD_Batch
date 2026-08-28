package com.example.student_management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Batch> batches = new ArrayList<>();
}
