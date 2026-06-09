package com.globant.university.dto;

import java.time.Instant;

public record StudentResponseDTO(
        Integer studentId,
        Integer universityId, // Solo el ID
        String name,
        Integer age,
        Integer studentCode,
        Instant createdAt
) {}