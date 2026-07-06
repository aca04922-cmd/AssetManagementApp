package com.example.demo.service.asset;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AssetEntity;
import com.example.demo.repository.asset.EditAssetRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EditAssetServiceImpl implements EditAssetService {

	private final EditAssetRepository repository;
	@Override
	public void editAsset(AssetEntity entity) {
		// TODO 自動生成されたメソッド・スタブ
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		repository.editAsset(entity,username);

	}

}
