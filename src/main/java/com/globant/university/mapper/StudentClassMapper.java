package com.globant.university.mapper;

import com.globant.university.dto.StudentClassResponseDTO;
import com.globant.university.model.StudentClass;

import java.util.List;

public class StudentClassMapper {

    public static StudentClassResponseDTO modelToResponseDTO(StudentClass studentClass) {
        return new StudentClassResponseDTO(
                studentClass.getStudentClassId(),
                studentClass.getStudent().getStudentId(),
                studentClass.getAclass().getClassId(),
                studentClass.getEnrolledAt()
        );
    }


    public static List<StudentClassResponseDTO> listModelToListResponseDTO(List<StudentClass> studentClassList) {
        return studentClassList.stream().map(StudentClassMapper::modelToResponseDTO).toList();
    }
}