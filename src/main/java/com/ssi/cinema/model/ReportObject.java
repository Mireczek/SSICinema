package com.ssi.cinema.model;

import java.util.Date;

import org.joda.time.DateTime;

public class ReportObject {
	
	private String cinema;
	
	private String movie;
	
	private Date day;
	
	private Long tickets;
	
	public String getCinema() {
		return cinema;
	}
	
	public void setCinema(String cinema) {
		this.cinema = cinema;
	}
	
	public String getMovie() {
		return movie;
	}
	
	public void setMovie(String movie) {
		this.movie = movie;
	}
	
	public Date getDay() {
		return day;
	}
	
	public String getDayString() {
		DateTime datetime = new DateTime(day);
		return datetime.toString("yyyy/MM/dd HH:mm");
	}
	
	public void setDay(Date day) {
		this.day = day;
	}
	
	public Long getTickets() {
		return tickets;
	}
	
	public void setTickets(Long tickets) {
		this.tickets = tickets;
	}
	
	public ReportObject(String cinema, String movie, Date day) {
		this.cinema = cinema;
		this.movie = movie;
		this.day = day;
	}
	
	@Override
	public boolean equals(Object obj) {
		ReportObject other = (ReportObject) obj;
		if (this.cinema.equals((other.getCinema()))
				&& this.movie.equals((other.getMovie()))
				&& this.day.equals(other.getDay())) {
			return true;
		}
		return false;
	}
}
