package com.globant.university.mapper;

import com.globant.university.dto.UniversityResponseDTO;
import com.globant.university.model.University;

import java.util.List;

public class UniversityMapper {

    public static UniversityResponseDTO modelToResponseDTO(University university){
        return new UniversityResponseDTO(
                university.getUniversityId(),
                university.getName(),
                university.getCreatedAt()
        );
    }

    public static List<UniversityResponseDTO> listModelToListResponseDTO(List<University> universityList) {
        return universityList.stream().map(UniversityMapper::modelToResponseDTO).toList();
    }
}