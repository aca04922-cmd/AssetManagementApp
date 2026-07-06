package com.example.demo.repository.institution;

import java.util.List;

import com.example.demo.entity.InstitutionEntity;

public interface InstitutionRepository {

	List<InstitutionEntity> getAllInstitution();
	
	String getInstitutionNameById(Integer institutionId);
	
}
