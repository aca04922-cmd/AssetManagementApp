package com.example.demo.controller.asset;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.AssetEntity;
import com.example.demo.form.DeleteAssetForm;
import com.example.demo.service.asset.DeleteAssetService;
import com.example.demo.service.asset.SearchAssetService;
import com.example.demo.service.institution.InstitutionService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DeleteController {
	private final DeleteAssetService dService;
	private final SearchAssetService sService;
	private final InstitutionService iService;


	@GetMapping("/confirm-delete-asset")
	public String confirmDeleteAsset(@RequestParam Integer assetId, Integer institutionId, Model model) {

		AssetEntity a = sService.findAssetById(assetId);
		DeleteAssetForm form = new DeleteAssetForm();
		org.springframework.beans.BeanUtils.copyProperties(a, form);
		model.addAttribute("deleteAssetForm", form);

		String institutionName = iService.getInstitutionNameById(institutionId);
		model.addAttribute("institutionName", institutionName);

		return "confirm-delete-asset";

	}

	@PostMapping("/complete-delete-asset")
	public String delelteAsset(@Validated DeleteAssetForm form, BindingResult bindingResult,
			RedirectAttributes redirectAttribute) {

		if (bindingResult.hasErrors()) {

			return "confirm-delete-asset";

		}

//		データベースの削除が完了した場合はtrue、失敗した場合はfalseが入る
		boolean isSuccess = dService.deleteAssetById(form.getAssetId());

		if (isSuccess) {

			redirectAttribute.addFlashAttribute("msg", "削除が完了しました");

			return "redirect:/complete";

		} else {

//			資産情報の削除に失敗した場合、"fali-delete"に遷移
			return "fail-delete";

		}

	}

}
