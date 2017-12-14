package com.ssi.cinema.controler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
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
	public Iterable<Cinema> getCinemasList() {
		Iterable<Cinema> cinemas = cinemaService.findAll();
		return cinemas;
	}
	
	@ModelAttribute("daysList")
	public List<String> getDaysList() {
		List<String> days = new ArrayList<>();
		DateTime datetime = new DateTime(new DateTime(DateTimeZone.UTC));
		for (int i = 0; i < 20; i++) {
			days.add("" + datetime.plusDays(i).getMonthOfYear() + "." + datetime.plusDays(i).getDayOfMonth());
		}
		return days;
	}
	
	@RequestMapping(value = "/reservationSelectCinema", method = RequestMethod.GET)
	public ModelAndView showReservationSelectCinema(HttpServletRequest request) {
		request.setAttribute("content", "reservationSelectCinema");
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "/reservationCreator", method = RequestMethod.GET)
	public ModelAndView showReservationSelectMovie(HttpServletRequest request, ModelMap map) {
		String selectedCinemaString = request.getParameter("selectedCinema");
		String selectedDayString = request.getParameter("selectedDay");
		String selectedMovieHourString = request.getParameter("selectedHour");
		String selectedMovieIdString = request.getParameter("selectedMovie");
		
		Reservation reservation = (Reservation) request.getSession().getAttribute("reservation");
		if (reservation == null) {
			reservation = new Reservation();
			request.getSession().setAttribute("reservation", reservation);
		}
		if (!StringUtils.isEmpty(selectedCinemaString)) {
			if (reservation.getCinema() == null || (reservation.getCinema() != null && !String.valueOf(reservation.getCinema().getId()).equals(selectedCinemaString))) {
				Cinema cinema = cinemaService.load(Long.valueOf(selectedCinemaString));
				reservation.setCinema(cinema);
			}
		}
		if (!StringUtils.isEmpty(selectedDayString)) {
			int year = new DateTime(new Date()).getYear();
			String month = selectedDayString.substring(0, selectedDayString.indexOf('.'));
			String day = selectedDayString.substring(selectedDayString.indexOf('.') + 1);
			reservation.setDate(new DateTime(year, Integer.parseInt(month), Integer.parseInt(day), 0, 0).toDate());
		}
		if (!StringUtils.isEmpty(selectedMovieHourString)) {
			if (reservation.getDate() != null) {
				DateTime datetime = new DateTime(reservation.getDate());
				String hour = selectedDayString.substring(0, selectedDayString.indexOf(':'));
				String minutes = selectedDayString.substring(selectedDayString.indexOf(':') + 1);
				reservation.setDate(datetime.withHourOfDay(Integer.parseInt(hour)).withMinuteOfHour(Integer.parseInt(minutes)).toDate());
			}
			
		}
		if (!StringUtils.isEmpty(selectedMovieIdString)) {
			if (reservation.getMovie() == null || (reservation.getMovie() != null && !String.valueOf(reservation.getMovie().getId()).equals(selectedMovieIdString))) {
				Movie movie = movieService.load(Long.valueOf(selectedMovieIdString));
				reservation.setMovie(movie);
			}
		}
		
		ModelAndView model = new ModelAndView();
		if (reservation.getCinema() == null && reservation.getDate() == null) {
			model.addObject("repertoire", getRepertoire(reservation.getCinema(), reservation.getDate()));
		}
		
		request.setAttribute("content", "reservationSelectCinema");
		model.addObject("chooseSeats", isReadyToSelectSeats(reservation));
		model.setViewName("index");
		return model;
	}
	
	private boolean isReadyToSelectSeats(Reservation reservation) {
		if (reservation.getCinema() == null) {
			return false;
		}
		if (reservation.getMovie() == null) {
			return false;
		}
		if (reservation.getDate() == null) {
			return false;
		}
		return true;
	}
	
	private Map<Movie, List<String>> getRepertoire(Cinema cinema, Date date) {
		// find by cinema and date
		Iterable<Repertoire> allRepertoires = repertoireService.findAll();
		Map<Movie, List<String>> data = new TreeMap<>();
		Date dateFrom = new DateTime(date).withTimeAtStartOfDay().toDate();
		Date dateTo = new DateTime(date).withTime(32, 59, 59, 0).toDate();
		for (Repertoire repertoire : allRepertoires) {
			if (cinema.getId() == repertoire.getRoom().getCinema().getId() &&
					dateFrom.before(repertoire.getDate()) && dateTo.after(repertoire.getDate())) {
				DateTime datetime = new DateTime(repertoire.getDate());
				
				if (data.containsKey(repertoire.getMovie())) {
					String hour = "" + datetime.getHourOfDay() + ":" + datetime.getMinuteOfHour();
					data.get(repertoire.getMovie()).add(hour);
				}
				else {
					List<String> hours = new ArrayList<>();
					hours.add("" + datetime.getHourOfDay() + ":" + datetime.getMinuteOfHour());
					data.put(repertoire.getMovie(), hours);
				}
			}
		}
		return data;
	}
	
}
