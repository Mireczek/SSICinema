package com.ssi.cinema.model;

public class Seat {
	
	private int row;
	
	private int column;
	
	private boolean locked;
	
	public Seat(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public String getPosition() {
		return "" + row + ":" + column;
	}
	
	public int getRow() {
		return row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public void setColumn(int column) {
		this.column = column;
	}
	
	public boolean isLocked() {
		return locked;
	}
	
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	
}
