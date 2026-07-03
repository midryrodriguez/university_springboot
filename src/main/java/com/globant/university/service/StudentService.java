package com.globant.university.service;

import com.globant.university.dto.CreateStudentRequestDTO;
import com.globant.university.dto.StudentResponseDTO;
import java.util.List;

public interface StudentService {
    List<StudentResponseDTO> findAll();

    StudentResponseDTO create(CreateStudentRequestDTO requestDTO) throws Exception;
}