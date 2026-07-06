package com.example.demo.repository.asset;

import com.example.demo.entity.AssetEntity;

public interface EditAssetRepository {

	void editAsset(AssetEntity entity, String username) ;
	
}
