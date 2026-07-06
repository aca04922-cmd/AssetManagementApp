package com.example.demo.repository.institution;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.InstitutionEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class InstitutionRepositoryImpl implements InstitutionRepository {

		private final JdbcTemplate jdbcTemplate;
	@Override
	public List<InstitutionEntity> getAllInstitution() {
		// TODO 自動生成されたメソッド・スタブ
		
		 String sql = " SELECT institution_id AS institutionId, institution_name AS institutionName "
				 	 +" from m_institution ";
		
		return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(InstitutionEntity.class));
	}
	
	public String getInstitutionNameById(Integer institutionId) {
		
		String sql = "SELECT institution_name AS institutionName "
					+" FROM m_institution "
					+" WHERE institution_id = ? ";
		
		return jdbcTemplate.queryForObject(sql,String.class,institutionId);
		
	}

}
