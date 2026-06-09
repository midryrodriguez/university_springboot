package com.globant.university.mapper;

import com.globant.university.dto.StudentResponseDTO;
import com.globant.university.model.Student;

public class StudentMapper {

    public static StudentResponseDTO modelToResponseDTO(Student student) {
        return new StudentResponseDTO(
                student.getStudentId(),
                student.getUniversity().getUniversityId(),
                student.getName(),
                student.getAge(),
                student.getStudentCode(),
                student.getCreatedAt()
        );
    }
}