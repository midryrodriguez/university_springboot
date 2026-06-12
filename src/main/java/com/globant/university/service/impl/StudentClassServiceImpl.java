package com.globant.university.service.impl;

import com.globant.university.dto.StudentClassResponseDTO;
import com.globant.university.mapper.StudentClassMapper;
import com.globant.university.model.StudentClass;
import com.globant.university.repository.StudentClassRepository;
import com.globant.university.service.StudentClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentClassServiceImpl implements StudentClassService {

    private final StudentClassRepository studentClassRepository;

    @Override
    public List<StudentClassResponseDTO> findAll() {
        List<StudentClass> studentClasses = studentClassRepository.findAll();
        return StudentClassMapper.listModelToListResponseDTO(studentClasses);
    }
}