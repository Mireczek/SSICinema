package com.ssi.cinema.backend.data.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class RoomStatus extends AbstractEntity {
	
	@NotNull
	@OneToOne
	private Room room;
	
	@NotNull
	private Date date;
	
	private String lockedSeats;
	
	public RoomStatus() {
		// An empty constructor is needed for all beans
	}
	
	public RoomStatus(Room room, Date date) {
		Objects.requireNonNull(room);
		Objects.requireNonNull(date);
		
		this.room = room;
		this.date = date;
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
	
	public String getLockedSeats() {
		return lockedSeats;
	}
	
	public void setLockedSeats(String lockedSeats) {
		this.lockedSeats = lockedSeats;
	}
}
