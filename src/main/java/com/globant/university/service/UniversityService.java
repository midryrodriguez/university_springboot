package com.globant.university.service;

import com.globant.university.dto.UniversityResponseDTO;
import java.util.List;

public interface UniversityService {
    List<UniversityResponseDTO> findAll();
}