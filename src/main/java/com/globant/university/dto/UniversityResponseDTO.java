package com.globant.university.dto;

import java.time.Instant;

public record UniversityResponseDTO(Integer universityId, String name, Instant createdAt) {
}
