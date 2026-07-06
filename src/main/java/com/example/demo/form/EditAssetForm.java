package com.example.demo.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EditAssetForm {

	@NotNull(message="資産番号は必須です")
	private Integer assetId;
	
	@NotBlank(message="資産名は必須です")
	private String assetName;
	
	@NotNull(message="金融機関の選択は必須です")
	private Integer institutionId;
	
	@NotNull(message="評価額は必須です")
	private Integer valuationAmount;
	
	@NotNull(message = "取得額は必須です")
	@Min(value=0, message="取得額は0以上である必要があります")
	private Integer acquisitionAmount;
	
}
