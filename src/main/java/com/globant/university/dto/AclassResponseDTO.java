package com.globant.university.dto;

import java.time.Instant;

public record AclassResponseDTO(
        Integer classId,
        Integer universityId, // Solo el ID
        String universityName,
        Integer teacherId,    // Solo el ID
        String teacherName,
        String name,
        String classroom,
        Instant createdAt
) {}