package com.globant.university.controller;

import com.globant.university.model.Aclass;
import com.globant.university.repository.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/class")
public class ClassControler {

    private final ClassRepository classRepository;

    @GetMapping("/getAll")
    public List<Aclass> getAll(){
        return classRepository.findAll();
    }
}