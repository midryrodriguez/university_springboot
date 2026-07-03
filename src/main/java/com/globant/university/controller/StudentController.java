package com.globant.university.controller;

import com.globant.university.dto.CreateStudentRequestDTO;
import com.globant.university.dto.StudentResponseDTO;
import com.globant.university.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponseDTO> create(@RequestBody CreateStudentRequestDTO requestDTO) throws Exception {
        StudentResponseDTO responseDTO = studentService.create(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}