package com.globant.university.controler;

import com.globant.university.model.University;
import com.globant.university.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/university")
public class UniversityControler {

    private final UniversityRepository universityRepository;

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }


    @GetMapping("/getAll")
    public List <University> getAll(){
        return universityRepository.findAll();

    }
}
