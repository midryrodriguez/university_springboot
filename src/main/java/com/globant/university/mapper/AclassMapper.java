package com.globant.university.mapper;

import com.globant.university.dto.AclassResponseDTO;
import com.globant.university.model.Aclass;

import java.util.ArrayList;
import java.util.List;

public class AclassMapper {

    // Mapear desde Entity hacia DTO Response
    public static AclassResponseDTO modelToResponseDTO(Aclass aclass) {
        return new AclassResponseDTO(
                aclass.getClassId(),
                aclass.getUniversity().getUniversityId(),
                aclass.getTeacher().getTeacherId(),
                aclass.getName(),
                aclass.getClassroom(),
                aclass.getCreatedAt()
        );
    }

    // Mapear Lista de Entity hacia Lista de Response DTO
    public static List<AclassResponseDTO> listModelToListResponseDTO(List<Aclass> aclassList) {
        /*1. Forma, usando for each iterando la lista para convertir cada uno de los objetos en DTO Response
        List<AclassResponseDTO> responseDTOS = new ArrayList<>();
        for (Aclass aclass : aclassList) {
            AclassResponseDTO aclassResponseDTO = modelToResponseDTO(aclass);
            responseDTOS.add(aclassResponseDTO);
        }
        return responseDTOS;*/
        /*2. Forma usando for convencional
        List<AclassResponseDTO> responseDTOS = new ArrayList<>();
        for (int i = 0; i<aclassList.size(); i++) {
            AclassResponseDTO aclassResponseDTO = modelToResponseDTO(aclassList.get(i));
            responseDTOS.add(aclassResponseDTO);
        }*/

        /*3. Forma, usando lambdas*/
        return aclassList.stream().map(AclassMapper::modelToResponseDTO).toList();
    }
}