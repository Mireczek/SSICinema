package com.ssi.cinema.controler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.cinema.backend.data.entity.Repertoire;
import com.ssi.cinema.backend.service.MovieService;
import com.ssi.cinema.backend.service.RepertoireService;
import com.ssi.cinema.backend.service.RoomService;

@Controller
public class RepertoireManagementController {
	
	@Autowired
	private RepertoireService repertoireService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value = "/repertoireAddProcess", method = RequestMethod.POST)
	public ModelAndView handleAddRepertoire(HttpServletRequest request, @ModelAttribute("repertoire") Repertoire repertoire) {
		
		ModelAndView model = new ModelAndView();
		try {
			repertoireService.save(repertoire);
			model.addObject("message", "repertoire succesfully created/updated");
			
		}
		catch (Exception e) {
			model.addObject("message", "Problems with creating repertoire!");
		}
		
		request.setAttribute("content", "manageRepertoire");
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "/manageRepertoire", method = RequestMethod.GET)
	public ModelAndView showUserManagement(HttpServletRequest request) {
		request.setAttribute("content", "manageRepertoire");
		ModelAndView model = new ModelAndView();
		
		model.addObject("repertoire", new Repertoire());
		model.addObject("roomList", roomService.findAll());
		model.addObject("movieList", movieService.findAll());
		model.setViewName("index");
		return model;
	}
	
}
