package com.globant.university.service.impl;

import com.globant.university.dto.CreateUniversityRequestDTO;
import com.globant.university.dto.UniversityResponseDTO;
import com.globant.university.mapper.UniversityMapper;
import com.globant.university.model.University;
import com.globant.university.repository.UniversityRepository;
import com.globant.university.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository universityRepository;

    @Override
    public List<UniversityResponseDTO> findAll() {
        List<University> universities = universityRepository.findAll();
        return UniversityMapper.listModelToListResponseDTO(universities);
    }

    @Override
    public UniversityResponseDTO create(CreateUniversityRequestDTO requestDTO) throws Exception {

        if (requestDTO == null){
            throw new Exception("CreateUniversityRequestDTO is required");
        }

        if (requestDTO.name() == null || requestDTO.name().isBlank()){
            throw new Exception("Name Is Required");
        }

        // 1. Creamos el objeto de tipo Entity y le pasamos los datos del Request
        University university = new University();
        university.setName(requestDTO.name());
        university.setCreatedAt(Instant.now()); // Asignamos la fecha y hora actual automáticamente

        // 2. Lo guardamos en la base de datos usando el Repository
        University savedUniversity = universityRepository.save(university);

        // 3. Mapeamos la entidad guardada a nuestro ResponseDTO y lo retornamos
        return UniversityMapper.modelToResponseDTO(savedUniversity);
    }
}