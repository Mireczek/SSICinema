package com.ssi.cinema.backend;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ssi.cinema.backend.data.entity.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
	
	Cinema findByEmail(String email);
	
	Page<Cinema> findByEmailLikeIgnoreCaseOrNameLikeIgnoreCaseOrRoleLikeIgnoreCase(String emailLike, String nameLike,
			String roleLike, Pageable pageable);
	
	long countByEmailLikeIgnoreCaseOrNameLikeIgnoreCase(String emailLike, String nameLike);
}
