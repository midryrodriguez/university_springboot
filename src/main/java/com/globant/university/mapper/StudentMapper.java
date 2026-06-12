package com.globant.university.mapper;

import com.globant.university.dto.StudentResponseDTO;
import com.globant.university.model.Student;

import java.util.List;

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

    public static List<StudentResponseDTO> listModelToListResponseDTO(List<Student> studentList) {
        return studentList.stream().map(StudentMapper::modelToResponseDTO).toList();
    }
}