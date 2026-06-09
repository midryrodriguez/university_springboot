package com.globant.university.dto;

import java.time.Instant;

public record AclassResponseDTO(
        Integer classId,
        Integer universityId, // Solo el ID
        Integer teacherId,    // Solo el ID
        String name,
        String classroom,
        Instant createdAt
) {}