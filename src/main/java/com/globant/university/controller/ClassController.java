package com.globant.university.controller;

import com.globant.university.dto.AclassResponseDTO;
import com.globant.university.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/class")
public class ClassController {

    // Inyección de dependencias desde el Repository
    // private final ClassRepository classRepository;

    // Nueva inyección de dependencias desde el Service
    private final ClassService classService;

    @GetMapping("/getAll")
    public List<AclassResponseDTO> getAll(){
        return classService.findAll();
    }
}