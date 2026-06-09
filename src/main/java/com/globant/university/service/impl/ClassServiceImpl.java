package com.globant.university.service.impl;

import com.globant.university.dto.AclassResponseDTO;
import com.globant.university.mapper.AclassMapper;
import com.globant.university.model.Aclass;
import com.globant.university.repository.ClassRepository;
import com.globant.university.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {

    // Inyección de dependencias desde el Repository
    private final ClassRepository classRepository;

    @Override
    public List<AclassResponseDTO> findAll() {
        // 1. Buscar las clases en Repository
        List<Aclass> aclasses = classRepository.findAll();

        // 2. Convertir a lista de DTO Response usando el mapper de las listas
        List<AclassResponseDTO> aclassResponseDTOS = AclassMapper.listModelToListResponseDTO(aclasses);

        // 3. Devolver la lista de Responses DTO
        return aclassResponseDTOS;
    }
}
