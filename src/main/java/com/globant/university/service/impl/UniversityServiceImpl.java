package com.globant.university.service.impl;

import com.globant.university.dto.UniversityResponseDTO;
import com.globant.university.mapper.UniversityMapper;
import com.globant.university.model.University;
import com.globant.university.repository.UniversityRepository;
import com.globant.university.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}