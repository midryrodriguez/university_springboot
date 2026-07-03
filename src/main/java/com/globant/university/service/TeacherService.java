package com.globant.university.service;

import com.globant.university.dto.CreateTeacherRequestDTO;
import com.globant.university.dto.TeacherResponseDTO;
import java.util.List;

public interface TeacherService {
    List<TeacherResponseDTO> findAll();

    TeacherResponseDTO create(CreateTeacherRequestDTO requestDTO) throws Exception;
}