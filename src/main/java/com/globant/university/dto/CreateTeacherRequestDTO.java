package com.globant.university.dto;

public record CreateTeacherRequestDTO(
        Integer universityId,
        String name,
        String teacherType,
        Double baseSalary,
        Integer expYears,
        Integer activeHoursPerWeek
) {}