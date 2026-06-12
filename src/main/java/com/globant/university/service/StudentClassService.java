package com.globant.university.service;

import com.globant.university.dto.StudentClassResponseDTO;
import java.util.List;

public interface StudentClassService {
    List<StudentClassResponseDTO> findAll();
}