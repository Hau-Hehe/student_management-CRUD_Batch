package com.example.student_management.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "batches")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RequiredArgsConstructor
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "batch_id", length = 11)
    private int batchId;

    @NonNull
    @Column(name = "batch_name", length = 45)
    private String batchName;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @NonNull
    @Column(name = "start_date", length = 10)
    private String startDate;
}
