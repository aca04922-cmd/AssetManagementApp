package com.example.demo.controller.asset;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.AssetEntity;
import com.example.demo.entity.InstitutionEntity;
import com.example.demo.form.EditAssetForm;
import com.example.demo.service.asset.EditAssetService;
import com.example.demo.service.asset.SearchAssetService;
import com.example.demo.service.institution.InstitutionService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EditController {

	private final SearchAssetService sService;
	private final EditAssetService eService;
	private final InstitutionService iService;


	@GetMapping("/edit-asset")
	public String edit(@ModelAttribute EditAssetForm form, Model model) {

		
		//選択した資産に関する情報をDBから取得
		AssetEntity a = sService.findAssetById(form.getAssetId());

		//AssetEntityをEditAssetFormに詰め替え
		org.springframework.beans.BeanUtils.copyProperties(a, form);
		

		model.addAttribute("editAssetForm", form);

		//金融機関情報をDBから取得
		List<InstitutionEntity> iList = iService.getAllInstitution();

		//金融機関情報をmodelに格納する
		model.addAttribute("institutionList", iList);

		return "edit-asset";
	}

	@PostMapping("/confirm-edit-asset")
	public String confirmEditAsset(@Validated @ModelAttribute EditAssetForm form, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {

			//金融機関情報をDBから取得
			List<InstitutionEntity> iList = iService.getAllInstitution();

			//金融機関情報をmodelに格納する
			model.addAttribute("institutionList", iList);

			return "edit-asset";

		}

		String institutionName = iService.getInstitutionNameById(form.getInstitutionId());

		model.addAttribute("institutionName", institutionName);

		return "confirm-edit-asset";

	}

	@PostMapping("complete-edit-asset")
	public String completeEditAsset(@Validated @ModelAttribute EditAssetForm form, BindingResult bindingResult,
			RedirectAttributes redirectAttribute, Model model) {

		if (bindingResult.hasErrors()) {

			//金融機関情報をDBから取得
			List<InstitutionEntity> iList = iService.getAllInstitution();

			//金融機関情報をmodelに格納する
			model.addAttribute("institutionList", iList);

			return "edit-asset";

		}

		AssetEntity e = new AssetEntity();

		org.springframework.beans.BeanUtils.copyProperties(form, e);

		eService.editAsset(e);

		redirectAttribute.addFlashAttribute("msg", "更新処理が完了しました");

		return "redirect:/complete";

	}
}
