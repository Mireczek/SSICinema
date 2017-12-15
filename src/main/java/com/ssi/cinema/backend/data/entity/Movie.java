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
	
	@NotNull
	@Size(min = 1, max = 255)
	private String link;
	
	public Movie() {
		// An empty constructor is needed for all beans
	}
	
	public Movie(String email, String name, String description, String link) {
		Objects.requireNonNull(description);
		Objects.requireNonNull(name);
		Objects.requireNonNull(link);
		
		this.description = description;
		this.name = name;
		this.link = link;
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
}
