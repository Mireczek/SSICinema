package com.ssi.cinema.controler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.ssi.cinema.model.Login;

@ControllerAdvice
public final class GlobalController {
	
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("login", new Login());
	}
}
