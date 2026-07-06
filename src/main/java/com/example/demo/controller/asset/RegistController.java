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
import com.example.demo.form.RegistAssetForm;
import com.example.demo.service.asset.RegistAssetService;
import com.example.demo.service.institution.InstitutionService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RegistController {

	private final RegistAssetService service;
	private final InstitutionService iService;


	@GetMapping("/mt-top")
	public String showTop(@ModelAttribute RegistAssetForm form) {
		return "mt-top";
	}

	@GetMapping("/show-regist-asset")
	public String showRegistAsset(@ModelAttribute RegistAssetForm form, Model model) {

//		金融機関情報をDBから取得
		List<InstitutionEntity> list = iService.getAllInstitution();

		model.addAttribute("institutionList", list);

		return "regist-asset";
	}

	@PostMapping("/confirm-regist-asset")
	public String confirmRegistAsset(@Validated @ModelAttribute RegistAssetForm form, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {

			List<InstitutionEntity> list = iService.getAllInstitution();

			model.addAttribute("institutionList", list);

			return "regist-asset";
		}

//		金融機関名をDBから取得。確認画面で金融機関IDではなく金融機関名を表示するため。
		String institutionName = iService.getInstitutionNameById(form.getInstitutionId());

		model.addAttribute("institutionName", institutionName);

		return "confirm-regist-asset";
	}

	@PostMapping("/complete-regist-asset")
	public String completeRegistAsset(@Validated @ModelAttribute RegistAssetForm form, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			return "regist-asset";
		}

		AssetEntity entity = new AssetEntity();

//		formの情報をentityに詰め替え
		org.springframework.beans.BeanUtils.copyProperties(form, entity);

//		DBへの登録処理実行
		service.regist(entity);

//		PRGパターンで処理。FlashAttributeを使用してリダイレクト先にメッセージを渡す。
		redirectAttributes.addFlashAttribute("msg", "資産登録が完了しました。");

		return "redirect:/complete";
	}
}
