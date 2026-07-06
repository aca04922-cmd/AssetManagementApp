package com.example.demo.repository.asset;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AssetEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RegistAssetRepositoryImpl implements RegistAssetRepository {

	private final JdbcTemplate jdbcTemplate;
	
	@Override
	public void registAsset(AssetEntity entity, String username) {
		
		final String SQL = "INSERT INTO t_asset "
				+ "(asset_name, institution_id, valuation_amount, acquisition_amount, username, updated_at) "
				+ "VALUES (?, ?, ?, ?, ?, NOW())"; 

		jdbcTemplate.update(SQL, 
				entity.getAssetName(), 
				entity.getInstitutionId(), 
				entity.getValuationAmount(), 
				entity.getAcquisitionAmount(), 
				username);
	}
}
