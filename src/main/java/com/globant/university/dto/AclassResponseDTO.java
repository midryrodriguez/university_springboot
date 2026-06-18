package com.globant.university.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;

public record AclassResponseDTO(

        @JsonProperty("class_id")
        Integer classId,

        @JsonProperty("university_id")
        Integer universityId,

        @JsonProperty("university_name")
        String universityName,

        @JsonProperty("teacher_id")
        Integer teacherId,

        @JsonProperty("teacher_name")
        String teacherName,

        @JsonProperty("name")
        String name,

        @JsonProperty("classroom")
        String classroom,

        @JsonProperty("created_at")
        Instant createdAt
) {}