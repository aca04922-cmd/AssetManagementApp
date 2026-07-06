package com.example.demo.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CompleteDeleteAssetForm {

	@NotNull(message="資産IDは必須です")
	@Min(value=1, message="資産IDは1以上である必要があります")
	private final Integer assetId;
	
}
