package com.ssi.cinema.controler;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import com.ssi.cinema.backend.data.entity.Room;
import com.ssi.cinema.backend.data.entity.RoomStatus;
import com.ssi.cinema.backend.service.CinemaService;
import com.ssi.cinema.backend.service.MovieService;
import com.ssi.cinema.backend.service.RepertoireService;
import com.ssi.cinema.backend.service.ReservationService;
import com.ssi.cinema.backend.service.RoomService;
import com.ssi.cinema.backend.service.RoomStatusService;
import com.ssi.cinema.model.ReservationData;
import com.ssi.cinema.model.Seat;

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
	
	@RequestMapping(value = "/showFinalizeReservation", method = RequestMethod.GET)
	public ModelAndView showFinalizeReservation(HttpServletRequest request) {
		
		request.setAttribute("content", "reservationFulfillData");
		
		ModelAndView model = new ModelAndView();
		model.addObject("reservationData", new ReservationData());
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "/finalizeReservationProcess", method = RequestMethod.POST)
	public ModelAndView finalizeReservation(HttpServletRequest request, @ModelAttribute("reservationData") ReservationData reservationData) {
		Reservation reservation = (Reservation) request.getSession().getAttribute("reservation");
		reservation.setName(reservationData.getName());
		reservation.setEmail(reservationData.getEmail());
		reservationService.save(reservation);
		saveRoomStatusForReservation(reservation);
		request.setAttribute("content", "reservationSelectCinema");
		request.getSession().removeAttribute("reservation");
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}
	
	private void saveRoomStatusForReservation(Reservation reservation) {
		RoomStatus roomStatus = roomStatusService.findByRoomAndDate(reservation.getRoom(), reservation.getDate());
		if (roomStatus == null) {
			roomStatus = new RoomStatus();
			roomStatus.setDate(reservation.getDate());
			roomStatus.setRoom(reservation.getRoom());
			roomStatus.setLockedSeats(reservation.getSeats());
		}
		else {
			roomStatus.setLockedSeats(roomStatus.getLockedSeats().concat(";").concat(reservation.getSeats()));
		}
		
		roomStatusService.save(roomStatus);
	}
	
	@RequestMapping(value = "/reservationCreator", method = RequestMethod.GET)
	public ModelAndView showReservationSelectMovie(HttpServletRequest request, ModelMap map) {
		String selectedCinemaString = request.getParameter("selectedCinema");
		String selectedDayString = request.getParameter("selectedDay");
		String selectedMovieHourRoomString = request.getParameter("selectedHourRoom");
		String selectedMovieIdString = request.getParameter("selectedMovie");
		System.out.println(selectedCinemaString + "-" + selectedDayString + "-" + selectedMovieHourRoomString + "-" + selectedMovieIdString);
		Reservation reservation = (Reservation) request.getSession().getAttribute("reservation");
		System.out.println(reservation);
		if (reservation == null) {
			reservation = new Reservation();
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
		if (!StringUtils.isEmpty(selectedMovieHourRoomString)) {
			if (reservation.getDate() != null) {
				DateTime datetime = new DateTime(reservation.getDate());
				String hour = selectedMovieHourRoomString.substring(0, selectedMovieHourRoomString.indexOf(':'));
				String minutes = selectedMovieHourRoomString.substring(selectedMovieHourRoomString.indexOf(':') + 1, selectedMovieHourRoomString.indexOf('r'));
				String roomIdString = selectedMovieHourRoomString.substring(selectedMovieHourRoomString.indexOf('r') + 1);
				reservation.setDate(datetime.withHourOfDay(Integer.parseInt(hour)).withMinuteOfHour(Integer.parseInt(minutes)).toDate());
				reservation.setRoom(roomService.load(Long.parseLong(roomIdString)));
			}
			
		}
		if (!StringUtils.isEmpty(selectedMovieIdString)) {
			if (reservation.getMovie() == null || (reservation.getMovie() != null && !String.valueOf(reservation.getMovie().getId()).equals(selectedMovieIdString))) {
				Movie movie = movieService.load(Long.valueOf(selectedMovieIdString));
				reservation.setMovie(movie);
			}
		}
		System.out.println(reservation.getCinema().getName());
		System.out.println(reservation.getDate());
		
		request.getSession().setAttribute("reservation", reservation);
		ModelAndView model = new ModelAndView();
		if (reservation.getCinema() != null && reservation.getDate() != null) {
			model.addObject("repertoire", getRepertoire(reservation.getCinema(), reservation.getDate()));
			model.addObject("repertoireMovies", getMoviesMap());
			
		}
		
		request.setAttribute("content", "reservationSelectCinema");
		model.addObject("chooseSeats", isReadyToSelectSeats(reservation));
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "/reservationCreatorSeatsSelection", method = RequestMethod.GET)
	public ModelAndView showReservationSelectSeat(HttpServletRequest request) {
		String selectedSeat = request.getParameter("selectedSeat");
		
		Reservation reservation = (Reservation) request.getSession().getAttribute("reservation");
		ModelAndView model = new ModelAndView();
		if (reservation == null) {
			request.setAttribute("content", "reservationSelectCinema");
		}
		else {
			request.setAttribute("content", "reservationSelectSeats");
			List<List<Seat>> seats = prepareSeatsMap(reservation);
			if (reservation.getSeats() != null && selectedSeat != null) {
				if (reservation.getSeats().contains(selectedSeat)) {
					reservation.setSeats(reservation.getSeats().replaceAll(selectedSeat + ";", ""));
				}
				else {
					reservation.setSeats(reservation.getSeats() + selectedSeat + ";");
				}
			}
			else {
				if (reservation.getSeats() == null) {
					reservation.setSeats("");
				}
				if (selectedSeat != null) {
					reservation.setSeats(reservation.getSeats() + selectedSeat + ";");
				}
			}
			model.addObject("selectedSeats", reservation.getSeats());
			model.addObject("seatsDefinition", seats);
		}
		
		model.setViewName("index");
		return model;
	}
	
	private List<List<Seat>> prepareSeatsMap(Reservation reservation) {
		Room room = reservation.getRoom();
		String seatsDefinition = room.getSeatsDefinition();
		int rows = Integer.parseInt(seatsDefinition.substring(0, seatsDefinition.indexOf("x")));
		int columns = Integer.parseInt(seatsDefinition.substring(seatsDefinition.indexOf("x") + 1));
		List<List<Seat>> seats = new ArrayList<>(columns);
		RoomStatus roomStatus = roomStatusService.findByRoomAndDate(room, reservation.getDate());
		Set<String> lockedSeats = getLockedSeats(roomStatus);
		for (int i = 0; i < columns; i++) {
			List<Seat> seatsRow = new ArrayList<>(rows);
			for (int j = 0; j < rows; j++) {
				Seat seat = new Seat(j, i);
				if (lockedSeats.contains("" + j + ":" + i)) {
					seat.setLocked(true);
				}
				seatsRow.add(seat);
				
			}
			seats.add(seatsRow);
		}
		return seats;
	}
	
	private Set<String> getLockedSeats(RoomStatus roomStatus) {
		if (roomStatus == null) {
			return new HashSet<>();
		}
		String lockedSeats = roomStatus.getLockedSeats();
		if (lockedSeats.isEmpty()) {
			return new HashSet<>();
		}
		Set<String> seats = new HashSet<>();
		String seatsSplitted[] = lockedSeats.split(";");
		for (String seat : seatsSplitted) {
			seats.add(seat);
		}
		return seats;
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
	
	private Map<Long, Movie> getMoviesMap() {
		Iterable<Movie> allMovies = movieService.findAll();
		Map<Long, Movie> data = new TreeMap<>();
		for (Movie movie : allMovies) {
			data.put(movie.getId(), movie);
		}
		return data;
	}
	
	private Map<Long, Map<String, Room>> getRepertoire(Cinema cinema, Date date) {
		Iterable<Repertoire> allRepertoires = repertoireService.findAll();
		Map<Long, Map<String, Room>> data = new TreeMap<>();
		Date dateFrom = new DateTime(date).withTimeAtStartOfDay().toDate();
		Date dateTo = new DateTime(date).withTime(23, 59, 59, 0).toDate();
		System.out.println(dateFrom);
		System.out.println(dateTo);
		for (Repertoire repertoire : allRepertoires) {
			System.out.println(repertoire.getRoom().getCinema().getId());
			System.out.println(repertoire.getDate());
			if (cinema.getId().equals(repertoire.getRoom().getCinema().getId()) &&
					dateFrom.before(repertoire.getDate()) && dateTo.after(repertoire.getDate())) {
				DateTime datetime = new DateTime(repertoire.getDate());
				
				if (data.containsKey(repertoire.getMovie().getId())) {
					String hour = "" + datetime.getHourOfDay() + ":" + datetime.getMinuteOfHour();
					data.get(repertoire.getMovie().getId()).put(hour, repertoire.getRoom());
				}
				else {
					Map<String, Room> hoursRoomMap = new TreeMap<>();
					String hour = "" + datetime.getHourOfDay() + ":" + datetime.getMinuteOfHour();
					hoursRoomMap.put(hour, repertoire.getRoom());
					data.put(repertoire.getMovie().getId(), hoursRoomMap);
				}
			}
		}
		System.out.println(data.entrySet().toString());
		return data;
	}
	
}
