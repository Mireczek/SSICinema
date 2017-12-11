package com.ssi.cinema.backend;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssi.cinema.backend.data.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
	Reservation findByEmail(String email);
	
}
