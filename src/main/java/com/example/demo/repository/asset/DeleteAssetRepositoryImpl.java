package com.example.demo.repository.asset;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DeleteAssetRepositoryImpl implements DeleteAssetRepository {

	private final JdbcTemplate jdbcTemplate;
	
	@Override
	public int deleteAssetById(Integer assetId, String username) {
		// TODO 自動生成されたメソッド・スタブ
		
		String sql = "DELETE FROM t_asset WHERE asset_id = ? and username = ?";
		
		int result =jdbcTemplate.update(sql, assetId, username);
		
		return result;

	}

}
