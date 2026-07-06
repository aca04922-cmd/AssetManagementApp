package com.example.demo.service.asset;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.repository.asset.DeleteAssetRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteAssetServiceImpl implements DeleteAssetService {

	private final DeleteAssetRepository repository;
	
	@Override
	public boolean deleteAssetById(Integer assetId) {
		// TODO 自動生成されたメソッド・スタブ
		
//		SecurityContextからusernameを取得する
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		int resutlt = repository.deleteAssetById(assetId,username);
		
		return resutlt > 0;

	}

}
