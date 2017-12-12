package com.ssi.cinema.controler;

import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.cinema.backend.data.entity.Cinema;
import com.ssi.cinema.backend.service.CinemaService;

@Controller
public class CinemaManagementController {
	
	@Autowired
	private CinemaService cinemaService;
	
	@RequestMapping(value = "/manageCinema", method = RequestMethod.GET)
	public ModelAndView showCinemaManagement(HttpServletRequest request) {
		request.setAttribute("content", "manageCinema");
		String selected = request.getParameter("item");
		ModelAndView model = new ModelAndView();
		Map<String, Cinema> cinemasMap = getCinemaNameCinemaMap();
		if (!StringUtils.isEmpty(selected)) {
			model.addObject("selectedCinema", cinemasMap.get(selected));
		}
		model.addObject("cinemasList", cinemasMap.keySet());
		model.setViewName("index");
		return model;
	}
	
	private Map<String, Cinema> getCinemaNameCinemaMap() {
		Iterable<Cinema> cinemas = cinemaService.findAll();
		Map<String, Cinema> map = new TreeMap<>();
		for (Cinema cinema : cinemas) {
			map.put(cinema.getName(), cinema);
		}
		return map;
	}
	
}
