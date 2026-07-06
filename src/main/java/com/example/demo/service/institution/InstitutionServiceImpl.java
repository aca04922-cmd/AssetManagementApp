package com.example.demo.service.institution;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.InstitutionEntity;
import com.example.demo.repository.institution.InstitutionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InstitutionServiceImpl implements InstitutionService {

	private final InstitutionRepository repository;
	
	@Override
	public List<InstitutionEntity> getAllInstitution() {
		// TODO 自動生成されたメソッド・スタブ
		
		return repository.getAllInstitution(); 
		
	}
	
	@Override
	public String getInstitutionNameById(Integer institutionId){
		
		return repository.getInstitutionNameById(institutionId);
		
	}
	
	

}
