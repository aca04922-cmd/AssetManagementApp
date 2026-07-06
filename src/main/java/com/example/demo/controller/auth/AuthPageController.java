package com.example.demo.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthPageController {

	

	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}
	
	@GetMapping(value="/login", params="failure")
	public String loginFail(Model model) {
		
		model.addAttribute("failureMessage","IDもしくはパスワードが違います");
		return "login";
	}
	
	@GetMapping("/register-complete")
    public String completeRegistt() {
    	
    		return "register-complete";
    	
    }
}
