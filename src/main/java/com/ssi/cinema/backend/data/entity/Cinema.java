package com.ssi.cinema.backend.data.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cinema extends AbstractEntity {
	
	@NotNull
	@Size(min = 1, max = 255)
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Size(min = 4, max = 255)
	private String city;
	
	@NotNull
	@Size(min = 4, max = 255)
	private String street;
	
	@NotNull
	@Size(min = 4, max = 255)
	private String phone;
	
	@NotNull
	@Size(min = 4, max = 255)
	private String email;
	
	public Cinema() {
		// An empty constructor is needed for all beans
	}
	
	public Cinema(String name, String city, String street, String phone, String email) {
		Objects.requireNonNull(email);
		Objects.requireNonNull(name);
		Objects.requireNonNull(street);
		Objects.requireNonNull(city);
		Objects.requireNonNull(phone);
		
		this.email = email;
		this.name = name;
		this.street = street;
		this.city = city;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
