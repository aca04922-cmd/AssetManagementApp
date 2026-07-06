package com.example.demo.service.asset;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AssetEntity;
import com.example.demo.repository.asset.RegistAssetRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistAssetServiceImpl implements RegistAssetService {

	private final RegistAssetRepository repository;
	
	@Override
	public void regist(AssetEntity entity) {
		// TODO 自動生成されたメソッド・スタブ
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();

		repository.registAsset(entity,username);
		
	}

}
