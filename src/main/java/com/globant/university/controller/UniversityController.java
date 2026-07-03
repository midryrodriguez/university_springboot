package com.globant.university.controller;

import com.globant.university.dto.CreateUniversityRequestDTO;
import com.globant.university.dto.UniversityResponseDTO;
import com.globant.university.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universities")
@RequiredArgsConstructor
public class UniversityController {

    private final UniversityService universityService;

    @GetMapping
    public List<UniversityResponseDTO> getAll(){
        return universityService.findAll();
    }

    @PostMapping
    public ResponseEntity<UniversityResponseDTO> create(@RequestBody CreateUniversityRequestDTO requestDTO) throws Exception {
        // Invocamos al método create del servicio
        UniversityResponseDTO responseDTO = universityService.create(requestDTO);

        // Retornamos el ResponseEntity con el objeto creado y estatus HTTP 201 (Created)
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}