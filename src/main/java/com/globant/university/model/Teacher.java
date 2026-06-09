package com.globant.university.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "teachers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Integer teacherId;

    @ManyToOne
    @JoinColumn(name = "university_id", referencedColumnName = "university_id")
    private University university;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "teacher_type", nullable = false, length = 100)
    private String teacherType;

    @Column(name = "base_salary", length = 150)
    private Double baseSalary;

    @Column(name = "exp_years", length = 150)
    private Integer expYears;

    @Column(name = "active_hours_per_week", length = 150)
    private Integer activeHoursPerWeek;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

}