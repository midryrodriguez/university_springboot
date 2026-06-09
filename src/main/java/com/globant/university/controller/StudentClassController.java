package com.globant.university.controller;

import com.globant.university.model.StudentClass;
import com.globant.university.repository.StudentClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student-class")
public class StudentClassController {

    private final StudentClassRepository studentClassRepository;

    @GetMapping("/getAll")
    public List<StudentClass> getAll(){
        return studentClassRepository.findAll();
    }
}