package com.globant.university.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record StudentResponseDTO(

        @JsonProperty("student_id")
        Integer studentId,

        @JsonProperty("university_id")
        Integer universityId,

        @JsonProperty("name")
        String name,

        @JsonProperty("age")
        Integer age,

        @JsonProperty("student_code")
        Integer studentCode,

        @JsonProperty("created_at")
        Instant createdAt
) {}