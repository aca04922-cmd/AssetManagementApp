package com.example.demo.repository.asset;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.AssetEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SearchAssetRepositoryImpl implements SearchAssetRepository {

	private final JdbcTemplate jdbcTemplate;

	@Override
	public List<AssetEntity> searchAssets(String username) {
		// TODO 自動生成されたメソッド・スタブ

		// JOINを使って、m_institution から金融機関名（institution_name）を取得する
		String sql = "SELECT "
				+ "  a.asset_id As assetId, "
				+ "  a.asset_name AS assetName, "
				+ "  a.institution_id AS institutionId, "
				+ "  i.institution_name AS institutionName, "
				+ "  a.valuation_amount AS valuationAmount, "
				+ "  a.acquisition_amount AS acquisitionAmount, "
				+ "  (a.valuation_amount - a.acquisition_amount) AS valuationGainLoss, " 
				+ "  a.updated_at As updatedAt "
				+ "FROM t_asset a "
				+ "INNER JOIN m_institution i "
				+ "  ON a.institution_id = i.institution_id "
				+ "WHERE a.username = ?"; 

		// BeanPropertyRowMapperが AS で付けた名前（institutionNameなど）を自動でセット
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(AssetEntity.class), username);

		
	}
	
	@Override
	public AssetEntity findAssetById(Integer assetId, String username) {
	    String sql = "SELECT "
	            + "  a.asset_id AS assetId, "
	            + "  a.asset_name AS assetName, "
	            + "  i.institution_id AS institutionId, " // 編集画面のセレクトボックスの初期値用にIDも取っておく
	            + "  i.institution_name AS institutionName, "
	            + "  a.valuation_amount AS valuationAmount, "
	            + "  a.acquisition_amount AS acquisitionAmount "
	            + "FROM t_asset a "
	            + "INNER JOIN m_institution i ON a.institution_id = i.institution_id "
	            + "WHERE a.asset_id = ? AND a.username = ?";

	    // 1件だけ取得する場合は queryForObject を使う
	    return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(AssetEntity.class), assetId, username);
	}

}
