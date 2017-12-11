package com.ssi.cinema.backend;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssi.cinema.backend.data.entity.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
	
	Cinema findByEmail(String email);
	
}
