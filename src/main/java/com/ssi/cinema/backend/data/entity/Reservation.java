package com.ssi.cinema.backend.data.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Reservation extends AbstractEntity {
	
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "email", unique = true)
	private String email;
	
	@NotNull
	@Size(min = 1, max = 255)
	private String name;
	
	@NotNull
	@OneToOne
	private Movie movie;
	
	@NotNull
	@OneToOne
	private Room room;
	
	@NotNull
	private Date date;
	
	@NotNull
	private String seats;
	
	public Reservation() {
		// An empty constructor is needed for all beans
	}
	
	public Reservation(String email, String name, Movie movie, Room room, Date date) {
		Objects.requireNonNull(email);
		Objects.requireNonNull(name);
		Objects.requireNonNull(room);
		Objects.requireNonNull(date);
		Objects.requireNonNull(movie);
		
		this.email = email;
		this.name = name;
		this.movie = movie;
		this.room = room;
		this.date = date;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Movie getMovie() {
		return movie;
	}
	
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public Room getRoom() {
		return room;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getSeats() {
		return seats;
	}
	
	public void setSeats(String seats) {
		this.seats = seats;
	}
	
}
