package com.ssi.cinema.controler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssi.cinema.model.Login;

@Controller
public class WelcomeController {
	
	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";
	
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		if (!model.containsKey("login")) {
			model.put("login", new Login());
		}
		model.put("message", this.message);
		return "index";
	}
	
}
