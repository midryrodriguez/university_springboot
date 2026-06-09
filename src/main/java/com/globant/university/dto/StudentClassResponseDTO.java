package com.globant.university.dto;

import java.time.Instant;

public record StudentClassResponseDTO(
        Integer studentClassId,
        Integer studentId, // Solo el ID
        Integer classId,   // Solo el ID
        Instant enrolledAt
) {}