package com.globant.university.service.impl;

import com.globant.university.dto.TeacherResponseDTO;
import com.globant.university.mapper.TeacherMapper;
import com.globant.university.model.Teacher;
import com.globant.university.repository.TeacherRepository;
import com.globant.university.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public List<TeacherResponseDTO> findAll() {
        List<Teacher> teachers = teacherRepository.findAll();
        return TeacherMapper.listModelToListResponseDTO(teachers);
    }
}