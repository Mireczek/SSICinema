package com.ssi.cinema.controler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	@RequestMapping("/")
	public String welcome(HttpServletRequest request, Map<String, Object> model) {
		request.setAttribute("content", "home");
		return "index";
	}
	
}
