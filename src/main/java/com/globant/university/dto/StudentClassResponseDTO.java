package com.globant.university.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record StudentClassResponseDTO(

        @JsonProperty("student_class_id")
        Integer studentClassId,

        @JsonProperty("student_id")
        Integer studentId,

        @JsonProperty("student_name")
        String studentname,

        @JsonProperty("class_id")
        Integer classId,

        @JsonProperty("class_name")
        String className,

        @JsonProperty("enrolled_at")
        Instant enrolledAt
) {}