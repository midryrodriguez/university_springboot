package com.globant.university.service;

import com.globant.university.dto.AclassResponseDTO;

import java.util.List;

public interface ClassService {
	List<AclassResponseDTO> findAll();
}
