package com.example.demo.form;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AssetForm {

	private Integer assetId;
	private String assetName;
	private String institutionName;
	private Integer valuationAmount;
	private Integer acquisitionAmount;
	private Integer valuationGainLoss; // 評価損益（評価額 - 取得額）
	private LocalDateTime updatedAt;
	
}
