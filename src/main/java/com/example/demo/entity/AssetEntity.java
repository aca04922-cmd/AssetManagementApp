package com.example.demo.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AssetEntity {

	private Integer assetId;
	private String assetName;
	private Integer institutionId;
	private String institutionName;
	private Integer valuationAmount;
	private Integer acquisitionAmount;
	private Integer valuationGainLoss; // 評価損益（評価額 - 取得額）
	private LocalDateTime updatedAt;	
}
