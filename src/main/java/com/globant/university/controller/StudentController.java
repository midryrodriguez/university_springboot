package com.globant.university.controller;

import com.globant.university.dto.StudentResponseDTO;

import com.globant.university.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/getAll")
    public List<StudentResponseDTO> getAll(){
        return studentService.findAll();
    }
}