package com.ssi.cinema.controler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.cinema.backend.data.entity.Movie;
import com.ssi.cinema.backend.data.entity.Repertoire;
import com.ssi.cinema.backend.data.entity.Room;
import com.ssi.cinema.backend.service.MovieService;
import com.ssi.cinema.backend.service.RepertoireService;
import com.ssi.cinema.backend.service.RoomService;
import com.ssi.cinema.model.RepertoireItem;

@Controller
public class RepertoireManagementController {
	
	@Autowired
	private RepertoireService repertoireService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value = "/repertoireAddProcess", method = RequestMethod.POST)
	public ModelAndView handleAddRepertoire(HttpServletRequest request, @ModelAttribute("repertoire") RepertoireItem repertoireItem) throws ParseException {
		ModelAndView model = new ModelAndView();
		Repertoire repertoire = new Repertoire();
		Room room = roomService.load(repertoireItem.getRoomId());
		System.out.println(room);
		Movie movie = movieService.load(repertoireItem.getMovieId());
		System.out.println(movie);
		Date date = getRepertoireDate(repertoireItem.getDate(), repertoireItem.getTime());
		System.out.println(date);
		
		repertoire.setDate(date);
		repertoire.setMovie(movie);
		repertoire.setRoom(room);
		System.out.println("try to save");
		repertoireService.save(repertoire);
		model.addObject("message", "repertoire succesfully created/updated");
		
		request.setAttribute("content", "manageRepertoire");
		model.addObject("roomList", roomService.findAll());
		model.addObject("movieList", movieService.findAll());
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "/manageRepertoire", method = RequestMethod.GET)
	public ModelAndView showUserManagement(HttpServletRequest request) {
		request.setAttribute("content", "manageRepertoire");
		ModelAndView model = new ModelAndView();
		
		model.addObject("repertoire", new RepertoireItem());
		model.addObject("roomList", roomService.findAll());
		model.addObject("movieList", movieService.findAll());
		model.setViewName("index");
		return model;
	}
	
	private Date getRepertoireDate(String strDate, String strTime) throws ParseException {
		System.out.println(strDate + " " + strTime);
		String target = strDate + " " + strTime;
		DateFormat df = new SimpleDateFormat("dd/MM/YYYY HH:mm");
		Date result = df.parse(target);
		
		return result;
	}
	
}
