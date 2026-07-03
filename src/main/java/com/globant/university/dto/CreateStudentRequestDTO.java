package com.globant.university.dto;

public record CreateStudentRequestDTO(
        Integer universityId,
        String name,
        Integer age,
        Integer studentCode
) {}