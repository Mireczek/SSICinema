package com.ssi.cinema.controler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssi.cinema.backend.data.entity.Reservation;
import com.ssi.cinema.backend.service.ReservationService;
import com.ssi.cinema.model.Report;
import com.ssi.cinema.model.ReportObject;

@Controller
public class ReportController {
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping(value = "/reportGenerator", method = RequestMethod.GET)
	public ModelAndView reportGenerator(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		request.setAttribute("content", "report");
		model.addObject("report", new Report());
		model.setViewName("index");
		return model;
	}
	
	@RequestMapping(value = "/generateReport", method = RequestMethod.POST)
	public ModelAndView handleUserRegister(HttpServletRequest request, @ModelAttribute("report") Report report) {
		
		ModelAndView model = new ModelAndView();
		Map<ReportObject, Long> reservationsMap = StreamSupport.stream(reservationService.findAll().spliterator(), false)
				.filter(reservation -> addToReport(reservation, report))
				.collect(Collectors.groupingBy(r -> buildReportObject(r), Collectors.counting()));
		List<ReportObject> reservations = reservationsMap.keySet().stream()
				.map(reservation -> {
					reservation.setTickets(reservationsMap.get(reservation));
					return reservation;
				})
				.collect(Collectors.toList());
		model.addObject("reservations", reservations);
		
		request.setAttribute("content", "report");
		model.setViewName("index");
		return model;
	}
	
	boolean addToReport(Reservation reservation, Report report) {
		return true;
		/*(report.getCinema().isEmpty() || (reservation.getCinema().getName().equals(report.getCinema())))
		&& (report.getMovie().isEmpty() || (reservation.getMovie().getName().equals(report.getMovie())))
		&& (reservation.getDate().getYear() + 100 == Integer.parseInt(report.getYear()))
		&& (reservation.getDate().getMonth() == Integer.parseInt(report.getMonth()))
		&& (report.getDay().isEmpty() || (reservation.getDate().getDate() == Integer.parseInt(report.getDay())));*/
	}
	
	ReportObject buildReportObject(Reservation reservation) {
		return new ReportObject(reservation.getCinema().getName(),
				reservation.getMovie().getName(), reservation.getDate());
	}
}
