package com.globant.university.controller;

import com.globant.university.dto.UniversityResponseDTO;
import com.globant.university.model.University;
import com.globant.university.repository.UniversityRepository;
import com.globant.university.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/university")
public class UniversityController {

    private final UniversityService universityService;

    @GetMapping("/getAll")
    public List<UniversityResponseDTO> getAll(){
        return universityService.findAll();
    }
}