package com.globant.university.mapper;

import com.globant.university.dto.UniversityResponseDTO;
import com.globant.university.model.University;

public class UniversityMapper {

    public static UniversityResponseDTO modelToResponseDTO(University university){
        return new UniversityResponseDTO(
                university.getUniversityId(),
                university.getName(),
                university.getCreatedAt()
        );
    }
}
