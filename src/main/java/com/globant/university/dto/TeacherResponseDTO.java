package com.globant.university.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record TeacherResponseDTO(

        @JsonProperty("teacher_id")
        Integer teacherId,

        @JsonProperty("university_id")
        Integer universityId,

        @JsonProperty("name")
        String name,

        @JsonProperty("teacher_type")
        String teacherType,

        @JsonProperty("base_salary")
        Double baseSalary,

        @JsonProperty("exp_years")
        Integer expYears,

        @JsonProperty("active_hours_per_week")
        Integer activeHoursPerWeek,

        @JsonProperty("created_at")
        Instant createdAt
) {}