package com.globant.university.service.impl;

import com.globant.university.dto.CreateStudentClassRequestDTO;
import com.globant.university.dto.StudentClassResponseDTO;
import com.globant.university.mapper.StudentClassMapper;
import com.globant.university.model.StudentClass;
import com.globant.university.repository.ClassRepository;
import com.globant.university.repository.StudentClassRepository;
import com.globant.university.repository.StudentRepository;
import com.globant.university.service.StudentClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentClassServiceImpl implements StudentClassService {

    private final StudentClassRepository studentClassRepository;
    // Daniel: Agregamos las dos inyecciones de dependencia para poder trabajar con el rompimiento de Student y Class
    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;

    @Override
    public List<StudentClassResponseDTO> findAll() {
        List<StudentClass> studentClasses = studentClassRepository.findAll();
        return StudentClassMapper.listModelToListResponseDTO(studentClasses);
    }

    @Override
    public StudentClassResponseDTO create(CreateStudentClassRequestDTO createStudentClassRequestDTO) throws Exception{
        return null;
    }
}