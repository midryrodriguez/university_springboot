package com.globant.university.service.impl;

import com.globant.university.dto.CreateTeacherRequestDTO;
import com.globant.university.dto.TeacherResponseDTO;
import com.globant.university.mapper.TeacherMapper;
import com.globant.university.model.Teacher;
import com.globant.university.model.University;
import com.globant.university.repository.TeacherRepository;
import com.globant.university.repository.UniversityRepository;
import com.globant.university.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    // Doble inyección de dependencias
    private final TeacherRepository teacherRepository;
    private final UniversityRepository universityRepository;

    @Override
    public List<TeacherResponseDTO> findAll() {
        List<Teacher> teachers = teacherRepository.findAll();
        return TeacherMapper.listModelToListResponseDTO(teachers);
    }

    @Override
    public TeacherResponseDTO create(CreateTeacherRequestDTO requestDTO) throws Exception {
        // 1. Validamos que el objeto request completo no sea nulo
        if (requestDTO == null) {
            throw new Exception("CreateTeacherRequestDTO is required");
        }

        // 2. Validamos el nombre del profesor
        if (requestDTO.name() == null || requestDTO.name().isBlank()) {
            throw new Exception("Name Is Required");
        }

        // 3. Validamos que nos envíen el ID de la universidad
        if (requestDTO.universityId() == null) {
            throw new Exception("University ID Is Required");
        }

        // 4. PASO CLAVE: Buscamos la universidad en la base de datos por su ID.
        // Si no la encuentra, lanza la excepción de una vez y no guarda nada.
        University university = universityRepository.findById(requestDTO.universityId())
                .orElseThrow(() -> new Exception("University not found with ID: " + requestDTO.universityId()));

        // 5. Si todo está bien, creamos la entidad Teacher y le asignamos la universidad encontrada
        Teacher teacher = new Teacher();
        teacher.setUniversity(university); // Pasamos el objeto completo de la universidad
        teacher.setName(requestDTO.name());
        teacher.setTeacherType(requestDTO.teacherType());
        teacher.setBaseSalary(requestDTO.baseSalary());
        teacher.setExpYears(requestDTO.expYears());
        teacher.setActiveHoursPerWeek(requestDTO.activeHoursPerWeek());
        teacher.setCreatedAt(Instant.now());

        // 6. Guardamos el profesor en la BD
        Teacher savedTeacher = teacherRepository.save(teacher);

        // 7. Retornamos mapeado a ResponseDTO
        return TeacherMapper.modelToResponseDTO(savedTeacher);
    }
}