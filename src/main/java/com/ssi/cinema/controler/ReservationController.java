package com.ssi.cinema.controler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.cinema.backend.data.entity.Cinema;
import com.ssi.cinema.backend.data.entity.Movie;
import com.ssi.cinema.backend.data.entity.Repertoire;
import com.ssi.cinema.backend.data.entity.Reservation;
import com.ssi.cinema.backend.service.CinemaService;
import com.ssi.cinema.backend.service.MovieService;
import com.ssi.cinema.backend.service.RepertoireService;
import com.ssi.cinema.backend.service.ReservationService;
import com.ssi.cinema.backend.service.RoomService;
import com.ssi.cinema.backend.service.RoomStatusService;

@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private CinemaService cinemaService;
	
	@Autowired
	private RepertoireService repertoireService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private RoomStatusService roomStatusService;
	
	@ModelAttribute("cinemasList")
	public Map<String, Cinema> getCinemasList() {
		Map<String, Cinema> cinemasMap = getCinemaNameCinemaMap();
		return cinemasMap;
	}
	
	@RequestMapping(value = "/reservationSelectCinema", method = RequestMethod.GET)
	public ModelAndView showReservationSelectCinema(@ModelAttribute("cinemasList") Map<String, Cinema> cinemasMap, HttpServletRequest request) {
		request.setAttribute("content", "reservationSelectCinema");
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "/reservationSelectMovie", method = RequestMethod.GET)
	public ModelAndView showReservationSelectMovie(HttpServletRequest request, ModelMap map) {
		request.setAttribute("content", "reservationSelectMovie");
		String selectedCinemaString = request.getParameter("selectedCinema");
		Map<String, Cinema> cinemasMap = (Map<String, Cinema>) map.get("cinemasList");
		if (cinemasMap == null) {
			System.out.println("fdsa;fasd");
		}
		Cinema selectedCinema = cinemasMap.get(selectedCinemaString);
		Map<Movie, Set<Date>> data = getRepertoireByMovieForCinema(selectedCinema);
		
		ModelAndView model = new ModelAndView();
		
		Reservation reservation = new Reservation();
		model.addObject("reservation", reservation);
		model.addObject("repertoire", data);
		model.setViewName("index");
		return model;
	}
	
	/*
	@RequestMapping(value = "/reservationSelectSeats", method = RequestMethod.GET)
	public ModelAndView showReservationSelectSeats(HttpServletRequest request) {
		request.setAttribute("content", "reservation");
		String selected = request.getParameter("item");
		ModelAndView model = new ModelAndView();
		Map<String, User> usersMap = getUserNameUserMap();
		if (!StringUtils.isEmpty(selected)) {
			model.addObject("selectedUser", usersMap.get(selected));
		}
		model.addObject("usersList", usersMap.keySet());
		model.addObject("user", new User());
		model.setViewName("index");
		return model;
	}*/
	
	private Map<String, Cinema> getCinemaNameCinemaMap() {
		Iterable<Cinema> cinemas = cinemaService.findAll();
		Map<String, Cinema> map = new TreeMap<>();
		for (Cinema cinema : cinemas) {
			map.put(cinema.getCity() + " - " + cinema.getName(), cinema);
		}
		return map;
	}
	
	private Map<Movie, Set<Date>> getRepertoireByMovieForCinema(Cinema cinema) {
		// TODO: change findByCinema
		Iterable<Repertoire> repertoires = repertoireService.findAll();
		//	Map<Long, Movie> moviesMap = getMoviesMap();
		Map<Movie, Set<Date>> map = new TreeMap<>();
		for (Repertoire repertoire : repertoires) {
			if (map.containsKey(repertoire.getMovie())) {
				map.get(repertoire.getMovie()).add(repertoire.getDate());
			}
			else {
				Set<Date> dates = new TreeSet<>();
				dates.add(repertoire.getDate());
				map.put(repertoire.getMovie(), dates);
			}
		}
		return map;
	}
	
	private Map<Long, Movie> getMoviesMap() {
		Iterable<Movie> movies = movieService.findAll();
		Map<Long, Movie> map = new HashMap<>();
		for (Movie movie : movies) {
			map.put(movie.getId(), movie);
		}
		return map;
	}
	
}
