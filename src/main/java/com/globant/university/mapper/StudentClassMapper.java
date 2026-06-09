package com.globant.university.mapper;

import com.globant.university.dto.StudentClassResponseDTO;
import com.globant.university.model.StudentClass;

public class StudentClassMapper {

    public static StudentClassResponseDTO modelToResponseDTO(StudentClass studentClass) {
        return new StudentClassResponseDTO(
                studentClass.getStudentClassId(),
                studentClass.getStudent().getStudentId(),
                studentClass.getAclass().getClassId(),
                studentClass.getEnrolledAt()
        );
    }
}