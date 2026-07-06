package com.example.demo.controller.asset;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

	@GetMapping("/complete")
	public String complete() {
		return "complete";
	}
	
}
