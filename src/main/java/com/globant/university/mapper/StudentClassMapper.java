package com.globant.university.mapper;

import com.globant.university.dto.StudentClassResponseDTO;
import com.globant.university.model.StudentClass;

import java.util.List;

public class StudentClassMapper {

    public static StudentClassResponseDTO modelToResponseDTO(StudentClass studentClass) {
        return new StudentClassResponseDTO(
                studentClass.getStudentClassId(),
                studentClass.getStudent() != null ? studentClass.getStudent().getStudentId() : null,
                studentClass.getStudent() != null ? studentClass.getStudent().getName() :null,
                studentClass.getAclass() != null ? studentClass.getAclass().getClassId() : null,
                studentClass.getAclass() !=null ? studentClass.getAclass().getName() : null,
                studentClass.getEnrolledAt()
        );
    }

    public static List<StudentClassResponseDTO> listModelToListResponseDTO(List<StudentClass> studentClassList) {
        return studentClassList.stream()
                .map(StudentClassMapper::modelToResponseDTO)
                .toList();
    }
}