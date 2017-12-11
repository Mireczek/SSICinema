package com.ssi.cinema.controler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssi.cinema.model.Login;

@Controller
public class WelcomeController {
	
	@RequestMapping("/")
	public String welcome(HttpServletRequest request, Map<String, Object> model) {
		if (!model.containsKey("login")) {
			model.put("login", new Login());
		}
		request.setAttribute("content", "home");
		return "index";
	}
	
}
