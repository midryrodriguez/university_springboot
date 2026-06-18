package com.globant.university.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record UniversityResponseDTO(

        @JsonProperty("university_id")
        Integer universityId,

        @JsonProperty("name")
        String name,

        @JsonProperty("created_at")
        Instant createdAt
) {}