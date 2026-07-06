package com.example.demo.service.asset;

import java.util.List;

import com.example.demo.entity.AssetEntity;

public interface SearchAssetService {

	List<AssetEntity> searchAssets();
	
	AssetEntity findAssetById(Integer assetId);
	
}
