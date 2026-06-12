package com.globant.university.controller;

import com.globant.university.dto.StudentClassResponseDTO;
import com.globant.university.service.StudentClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student-class")
public class StudentClassController {

    private final StudentClassService studentClassService;

    @GetMapping("/getAll")
    public List<StudentClassResponseDTO> getAll(){
        return studentClassService.findAll();
    }
}