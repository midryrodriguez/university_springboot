package com.globant.university.controller;

import com.globant.university.dto.CreateStudentClassRequestDTO;
import com.globant.university.dto.StudentClassResponseDTO;
import com.globant.university.service.StudentClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student-class")
public class StudentClassController {

    private final StudentClassService studentClassService;

    @PostMapping
    public ResponseEntity<StudentClassResponseDTO> create(@RequestBody CreateStudentClassRequestDTO requestDTO) throws Exception {
        StudentClassResponseDTO responseDTO = studentClassService.create(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public List<StudentClassResponseDTO> getAll(){
        return studentClassService.findAll();
    }

    @GetMapping("/getByClassId/{classId}")
    public List<StudentClassResponseDTO> getByClassId(@PathVariable Integer classId) throws Exception {
        return studentClassService.findByClassId(classId);
    }

    // Nuevo endpoint GET para buscar por estudiante
    @GetMapping("/getByStudentId/{studentId}")
    public List<StudentClassResponseDTO> getByStudentId(@PathVariable Integer studentId) throws Exception {
        return studentClassService.findByStudentId(studentId);
    }
}