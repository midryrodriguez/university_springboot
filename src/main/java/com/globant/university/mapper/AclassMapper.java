package com.globant.university.mapper;

import com.globant.university.dto.AclassResponseDTO;
import com.globant.university.model.Aclass;

public class AclassMapper {

    public static AclassResponseDTO modelToResponseDTO(Aclass aclass) {
        return new AclassResponseDTO(
                aclass.getClassId(),
                aclass.getUniversity().getUniversityId(),
                aclass.getTeacher().getTeacherId(),
                aclass.getName(),
                aclass.getClassroom(),
                aclass.getCreatedAt()
        );
    }
}