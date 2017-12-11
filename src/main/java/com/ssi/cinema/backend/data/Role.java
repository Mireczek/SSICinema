package com.ssi.cinema.backend.data;

public class Role {
	
	public static final String WORKER = "worker";
	
	public static final String ADMIN = "admin";
	
	private Role() {
		// Static methods and fields only
	}
	
	public static String[] getAllRoles() {
		return new String[] { WORKER, ADMIN };
	}
	
}
