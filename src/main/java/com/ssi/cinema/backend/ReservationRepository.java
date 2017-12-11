package com.ssi.cinema.backend;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ssi.cinema.backend.data.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
	Reservation findByEmail(String email);
	
	Page<Reservation> findByEmailLikeIgnoreCaseOrNameLikeIgnoreCaseOrRoleLikeIgnoreCase(String emailLike, String nameLike,
			String roleLike, Pageable pageable);
	
	long countByEmailLikeIgnoreCaseOrNameLikeIgnoreCase(String emailLike, String nameLike);
}
