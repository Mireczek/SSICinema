package com.ssi.cinema.model;

public class RoomDefinition {
	
	private String name;
	
	private String cinema;
	
	private String seatsRows;
	
	private String seatsColumns;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCinema() {
		return cinema;
	}
	
	public void setCinema(String cinema) {
		this.cinema = cinema;
	}
	
	public String getSeatsRows() {
		return seatsRows;
	}
	
	public void setSeatsRows(String seatsRows) {
		this.seatsRows = seatsRows;
	}
	
	public String getSeatsColumns() {
		return seatsColumns;
	}
	
	public void setSeatsColumns(String seatsColumns) {
		this.seatsColumns = seatsColumns;
	}
}
