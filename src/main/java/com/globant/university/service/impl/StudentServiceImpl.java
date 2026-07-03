package com.globant.university.service.impl;

import com.globant.university.dto.CreateStudentRequestDTO;
import com.globant.university.dto.StudentResponseDTO;
import com.globant.university.mapper.StudentMapper;
import com.globant.university.model.Student;
import com.globant.university.model.University;
import com.globant.university.repository.StudentRepository;
import com.globant.university.repository.UniversityRepository;
import com.globant.university.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    // Doble inyección: repositorio de estudiantes y de universidades
    private final StudentRepository studentRepository;
    private final UniversityRepository universityRepository;

    @Override
    public List<StudentResponseDTO> findAll() {
        List<Student> students = studentRepository.findAll();
        return StudentMapper.listModelToListResponseDTO(students);
    }

    @Override
    public StudentResponseDTO create(CreateStudentRequestDTO requestDTO) throws Exception {
        // 1. Validamos que el request completo no llegue nulo
        if (requestDTO == null) {
            throw new Exception("CreateStudentRequestDTO is required");
        }

        // 2. Validamos el nombre del estudiante
        if (requestDTO.name() == null || requestDTO.name().isBlank()) {
            throw new Exception("Name Is Required");
        }

        // 3. Validamos que venga el ID de la universidad
        if (requestDTO.universityId() == null) {
            throw new Exception("University ID Is Required");
        }

        // 4. Buscamos la universidad en la BD para asegurar que exista
        University university = universityRepository.findById(requestDTO.universityId())
                .orElseThrow(() -> new Exception("University not found with ID: " + requestDTO.universityId()));

        // 5. Mapeamos manualmente los datos al objeto de la entidad Student
        Student student = new Student();
        student.setUniversity(university); // Pasamos la entidad completa de la universidad
        student.setName(requestDTO.name());
        student.setAge(requestDTO.age());
        student.setStudentCode(requestDTO.studentCode());
        student.setCreatedAt(Instant.now());

        // 6. Guardamos el registro en la BD
        Student savedStudent = studentRepository.save(student);

        // 7. Devolvemos el DTO de respuesta usando tu mapper estructurado
        return StudentMapper.modelToResponseDTO(savedStudent);
    }
}