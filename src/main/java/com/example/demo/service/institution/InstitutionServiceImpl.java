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
	
//	全金融機関の情報を取得する
	@Override
	public List<InstitutionEntity> getAllInstitution() {
		// TODO 自動生成されたメソッド・スタブ
		
		return repository.getAllInstitution(); 
		
	}
	
//	金融機関IDを使って個別の金融機関名を取得する
	@Override
	public String getInstitutionNameById(Integer institutionId){
		
		return repository.getInstitutionNameById(institutionId);
		
	}
	
	

}
