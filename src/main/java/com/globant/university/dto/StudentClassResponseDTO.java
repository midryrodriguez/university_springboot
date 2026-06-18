package com.globant.university.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record StudentClassResponseDTO(

        @JsonProperty("student_class_id")
        Integer studentClassId,

        @JsonProperty("student_id")
        Integer studentId,

        @JsonProperty("class_id")
        Integer classId,

        @JsonProperty("enrolled_at")
        Instant enrolledAt
) {}