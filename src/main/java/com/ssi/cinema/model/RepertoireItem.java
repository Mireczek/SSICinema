package com.ssi.cinema.model;

public class RepertoireItem {
	
	private Long roomId;
	
	private Long movieId;
	
	private String date;
	
	private String time;
	
	public Long getRoomId() {
		return roomId;
	}
	
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	
	public Long getMovieId() {
		return movieId;
	}
	
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
}
