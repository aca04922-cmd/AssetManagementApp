package com.example.demo.controller.asset;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entity.AssetEntity;
import com.example.demo.form.AssetForm;
import com.example.demo.service.asset.SearchAssetService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class SearchController {

	private final SearchAssetService service;

	@GetMapping("/show-asset-list")
	public String showSearchAsset(@ModelAttribute AssetForm form, Model model) {


		List<AssetEntity> list = service.searchAssets();

		Integer totalValuation = list.stream()
				.mapToInt(AssetEntity::getValuationAmount) // 評価額を取得し、合計する
				.sum();

		Integer totalAcquisition = list.stream()
				.mapToInt(AssetEntity::getAcquisitionAmount) // 取得額を取得し、合計する
				.sum();

		Integer totalGainLoss = list.stream()
				.mapToInt(AssetEntity::getValuationGainLoss) // 評価損益額を取得し、合計する
				.sum();

//		取得したリストと合計した値をモデルに登録する
		model.addAttribute("assetList", list);
		model.addAttribute("totalValuation", totalValuation);
		model.addAttribute("totalAcquisition", totalAcquisition);
		model.addAttribute("totalGainLoss", totalGainLoss);

		return "show-asset-list";
	}

}