package com.globant.university.controller;

import com.globant.university.dto.CreateTeacherRequestDTO;
import com.globant.university.dto.TeacherResponseDTO;
import com.globant.university.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherResponseDTO> create(@RequestBody CreateTeacherRequestDTO requestDTO) throws Exception {
        TeacherResponseDTO responseDTO = teacherService.create(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}