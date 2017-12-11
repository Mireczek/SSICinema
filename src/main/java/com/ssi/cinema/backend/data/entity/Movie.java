package com.ssi.cinema.backend.data.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Movie extends AbstractEntity {
	
	@NotNull
	@Size(min = 4, max = 255)
	@Column(name = "name", unique = true)
	private String name;
	
	@NotNull
	@Size(min = 1, max = 255)
	private String description;
	
	public Movie() {
		// An empty constructor is needed for all beans
	}
	
	public Movie(String email, String name, String description) {
		Objects.requireNonNull(description);
		Objects.requireNonNull(name);
		
		this.description = description;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
}
