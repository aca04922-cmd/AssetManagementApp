package com.example.demo.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class DeleteAssetForm {

	@NotNull(message="資産番号は必須です")
	@Min(value=1,message="資産番号は1以上である必要があります")
	private Integer assetId;
	
	private String assetName;
	
	private Integer institutionId;
	
	private Integer valuationAmount;
	
	private Integer acquisitionAmount;
	
	
	
}
