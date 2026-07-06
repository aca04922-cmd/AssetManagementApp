package com.example.demo.repository.asset;

import java.util.List;

import com.example.demo.entity.AssetEntity;

public interface SearchAssetRepository {
	
	List<AssetEntity> searchAssets(String username);
	
	AssetEntity findAssetById(Integer assetId, String username) ;
	
}
