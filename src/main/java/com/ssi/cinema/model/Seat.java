package com.ssi.cinema.model;

public class Seat {
	
	private String row;
	
	private String column;
	
	public String getRow() {
		return row;
	}
	
	public void setRow(String row) {
		this.row = row;
	}
	
	public String getColumn() {
		return column;
	}
	
	public void setColumn(String column) {
		this.column = column;
	}
	
	public String getPositionColumn() {
		return row + column;
	}
}
