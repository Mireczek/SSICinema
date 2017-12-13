package com.ssi.cinema.controler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.cinema.backend.data.entity.Movie;
import com.ssi.cinema.backend.service.MovieService;

@Controller
public class MoviesController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value = "/movieAddProcess", method = RequestMethod.POST)
	public ModelAndView handleUserRegister(HttpServletRequest request, @ModelAttribute("movie") Movie movie) {
		
		ModelAndView model = new ModelAndView();
		try {
			movieService.save(movie);
			model.addObject("message", "Movie succesfully created/updated");
			
		}
		catch (Exception e) {
			model.addObject("message", "Problems with creating user!");
		}
		
		request.setAttribute("content", "manageMovies");
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "/manageMovies", method = RequestMethod.GET)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("content", "manageMovies");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addObject("movie", new Movie());
		return mav;
	}
	
}