package com.globant.university.service.impl;

// ... (los mismos imports que ya tienes)

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
    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;

    // ... (findAll, create y findByClassId se quedan exactamente igual)

    @Override
    public List<StudentClassResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public StudentClassResponseDTO create(CreateStudentClassRequestDTO requestDTO) throws Exception {
        return null;
    }

    @Override
    public List<StudentClassResponseDTO> findByClassId(Integer classId) throws Exception {
        if (classId == null || classId == 0) {
            throw new Exception("Class ID Is Required");
        }
        List<StudentClass> studentClasses = studentClassRepository.findByAclassClassId(classId);
        return StudentClassMapper.listModelToListResponseDTO(studentClasses);
    }


    @Override
    public List<StudentClassResponseDTO> findByStudentId(Integer studentId) throws Exception {
        if (studentId == null || studentId == 0) {
            throw new Exception("Student ID Is Required");
        }
        List<StudentClass> studentClasses = studentClassRepository.findByStudentStudentId(studentId);
        return StudentClassMapper.listModelToListResponseDTO(studentClasses);
    }
}