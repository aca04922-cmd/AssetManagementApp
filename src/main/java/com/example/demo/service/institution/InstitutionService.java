package com.example.demo.service.institution;

import java.util.List;

import com.example.demo.entity.InstitutionEntity;

public interface InstitutionService {

	List<InstitutionEntity> getAllInstitution();
	
	String getInstitutionNameById(Integer institutionId);
	
}
