package com.ssi.cinema.controler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.cinema.backend.service.CinemaService;

@Controller
public class WelcomeController {
	
	@Autowired
	private CinemaService cinemaService;
	
	@RequestMapping("/")
	public ModelAndView welcome(HttpServletRequest request) {
		request.setAttribute("content", "home");
		ModelAndView model = new ModelAndView();
		model.addObject("cinemasList", cinemaService.findAll());
		model.setViewName("index");
		return model;
	}
	
}
