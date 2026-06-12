package com.globant.university.mapper;

import com.globant.university.dto.TeacherResponseDTO;
import com.globant.university.model.Teacher;

import java.util.List;

public class TeacherMapper {

    public static TeacherResponseDTO modelToResponseDTO(Teacher teacher) {
        return new TeacherResponseDTO(
                teacher.getTeacherId(),
                teacher.getUniversity().getUniversityId(),
                teacher.getName(),
                teacher.getTeacherType(),
                teacher.getBaseSalary(),
                teacher.getExpYears(),
                teacher.getActiveHoursPerWeek(),
                teacher.getCreatedAt()
        );
    }

    public static List<TeacherResponseDTO> listModelToListResponseDTO(List<Teacher> teacherList) {
        return teacherList.stream().map(TeacherMapper::modelToResponseDTO).toList();
    }
}