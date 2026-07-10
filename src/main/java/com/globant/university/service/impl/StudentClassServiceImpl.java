package com.globant.university.service.impl;

import com.globant.university.dto.CreateStudentClassRequestDTO;
import com.globant.university.dto.StudentClassResponseDTO;
import com.globant.university.mapper.StudentClassMapper;
import com.globant.university.model.Aclass;
import com.globant.university.model.Student;
import com.globant.university.model.StudentClass;
import com.globant.university.repository.ClassRepository;
import com.globant.university.repository.StudentClassRepository;
import com.globant.university.repository.StudentRepository;
import com.globant.university.service.StudentClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentClassServiceImpl implements StudentClassService {

    private final StudentClassRepository studentClassRepository;
    private final StudentRepository studentRepository;
    private final ClassRepository classRepository; // Repositorio de tus clases (Aclass)

    @Override
    public List<StudentClassResponseDTO> findAll() {
        List<StudentClass> studentClasses = studentClassRepository.findAll();
        return StudentClassMapper.listModelToListResponseDTO(studentClasses);
    }

    @Override
    public StudentClassResponseDTO create(CreateStudentClassRequestDTO requestDTO) throws Exception {
        // 1. Validaciones de nulos iniciales
        if (requestDTO == null) {
            throw new Exception("CreateStudentClassRequestDTO is required");
        }
        if (requestDTO.studentId() == null) {
            throw new Exception("Student ID Is Required");
        }
        if (requestDTO.classId() == null) {
            throw new Exception("Class ID Is Required");
        }

        // 2. Buscamos si el estudiante existe
        Student student = studentRepository.findById(requestDTO.studentId())
                .orElseThrow(() -> new Exception("Student not found with ID: " + requestDTO.studentId()));

        // 3. Buscamos si la clase existe
        Aclass aclass = classRepository.findById(requestDTO.classId())
                .orElseThrow(() -> new Exception("Class not found with ID: " + requestDTO.classId()));

        // 4. Creamos la entidad intermedia y la asociamos
        StudentClass studentClass = new StudentClass();
        studentClass.setStudent(student);
        studentClass.setAclass(aclass);
        studentClass.setEnrolledAt(Instant.now());

        // 5. Guardamos en la base de datos
        StudentClass savedStudentClass = studentClassRepository.save(studentClass);

        // 6. Retornamos el DTO de respuesta usando tu mapper estructurado
        return StudentClassMapper.modelToResponseDTO(savedStudentClass);
    }
}