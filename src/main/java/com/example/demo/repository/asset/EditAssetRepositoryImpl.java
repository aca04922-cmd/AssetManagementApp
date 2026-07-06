package com.example.demo.repository.asset;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AssetEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EditAssetRepositoryImpl implements EditAssetRepository {
		private final JdbcTemplate jdbcTemplate;
	@Override
	public void editAsset(AssetEntity entity, String username) {
		// TODO 自動生成されたメソッド・スタブ
		
		// 💡 これが正しいUPDATE文の構造です
		String sql = "UPDATE t_asset "
		        + "SET asset_name = ?, "
		        + "    institution_id = ?, "
		        + "    valuation_amount = ?, "
		        + "    acquisition_amount = ?, "
		        + "    updated_at = NOW() " 
		        + "WHERE asset_id = ? AND username = ?"; 
		
		jdbcTemplate.update(sql,entity.getAssetName(),entity.getInstitutionId(),entity.getValuationAmount(),entity.getAcquisitionAmount(),entity.getAssetId(),username); 
		
	}

}
