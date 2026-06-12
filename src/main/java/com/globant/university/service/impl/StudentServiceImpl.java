package com.globant.university.service.impl;

import com.globant.university.dto.StudentResponseDTO;
import com.globant.university.mapper.StudentMapper;
import com.globant.university.model.Student;
import com.globant.university.repository.StudentRepository;
import com.globant.university.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentResponseDTO> findAll() {
        List<Student> students = studentRepository.findAll();
        return StudentMapper.listModelToListResponseDTO(students);
    }
}