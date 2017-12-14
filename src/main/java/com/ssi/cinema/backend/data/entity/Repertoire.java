package com.ssi.cinema.backend.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Repertoire extends AbstractEntity {
	
	@NotNull
	@Column(length = 1000000)
	private Room room;
	
	@NotNull
	@Column(length = 1000000)
	private Movie movie;
	
	@NotNull
	private Date date;
	
	public Repertoire() {
		// An empty constructor is needed for all beans
	}
	
	public Room getRoom() {
		return room;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public Movie getMovie() {
		return movie;
	}
	
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
}
