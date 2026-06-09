package com.globant.university.controller;

import com.globant.university.model.Teacher;
import com.globant.university.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teacher")
public class TeacherController {

    private final TeacherRepository teacherRepository;

    @GetMapping("/getAll")
    public List<Teacher> getAll(){
        return teacherRepository.findAll();
    }
}