package com.globant.university.controller;

import com.globant.university.model.Student;
import com.globant.university.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentController {

    private final StudentRepository studentRepository;

    @GetMapping("/getAll")
    public List<Student> getAll(){
        return studentRepository.findAll();
    }
}