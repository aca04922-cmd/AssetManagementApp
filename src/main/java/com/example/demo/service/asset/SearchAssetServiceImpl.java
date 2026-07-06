package com.example.demo.service.asset;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AssetEntity;
import com.example.demo.repository.asset.SearchAssetRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SearchAssetServiceImpl implements SearchAssetService {

	private final SearchAssetRepository repository;

//	全ての資産情報を取得する
	@Override
	public List<AssetEntity> searchAssets() {
		// TODO 自動生成されたメソッド・スタブ
		
//		SecurityContextからusernameを取得する
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();

		List<AssetEntity> list = repository.searchAssets(username);

		return list;
	}
	
//	個別の資産情報を取得する
	@Override
	public AssetEntity findAssetById(Integer assetId) {
		
//		SecurityContextからusernameを取得する
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		return repository.findAssetById(assetId,username);
		
	}
	
	

}
