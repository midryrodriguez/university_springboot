package com.globant.university.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Instant;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @ManyToOne
    @JoinColumn(name = "university_id", referencedColumnName = "university_id")
    private University university;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "age", nullable = false, length = 100)
    private Integer age;

    @Column(name = "student_code", nullable = false, unique = true, length = 150)
    private Integer studentCode;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

}