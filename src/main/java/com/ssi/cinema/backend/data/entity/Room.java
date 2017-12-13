package com.ssi.cinema.backend.data.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Room extends AbstractEntity {
	
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "name", unique = true)
	private String name;
	
	@NotNull
	@ManyToOne
	private Cinema cinema;
	
	@NotNull
	private String seatsDefinition;
	
	public Room() {
		// An empty constructor is needed for all beans
	}
	
	public Room(String name, Cinema cinema) {
		Objects.requireNonNull(cinema);
		Objects.requireNonNull(name);
		
		this.cinema = cinema;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Cinema getCinema() {
		return cinema;
	}
	
	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	
	public String getSeatsDefinition() {
		return seatsDefinition;
	}
	
	public void setSeatsDefinition(String seatsDefinition) {
		this.seatsDefinition = seatsDefinition;
	}
	
}
