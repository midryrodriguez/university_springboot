package com.globant.university.dto;

import java.time.Instant;

public record TeacherResponseDTO(
        Integer teacherId,
        Integer universityId, // Solo el ID, sin la clase completa
        String name,
        String teacherType,
        Double baseSalary,
        Integer expYears,
        Integer activeHoursPerWeek,
        Instant createdAt
) {

}