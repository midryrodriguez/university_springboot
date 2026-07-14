package com.globant.university.repository;

import com.globant.university.model.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentClassRepository extends JpaRepository<StudentClass, Integer> {

    List<StudentClass> findByAclassClassId(Integer classId);


    List<StudentClass> findByStudentStudentId(Integer studentId);
}