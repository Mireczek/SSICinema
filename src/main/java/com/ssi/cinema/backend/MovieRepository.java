package com.ssi.cinema.backend;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ssi.cinema.backend.data.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	Movie findByName(String name);
	
	Page<Movie> findByEmailLikeIgnoreCaseOrNameLikeIgnoreCaseOrRoleLikeIgnoreCase(String emailLike, String nameLike,
			String roleLike, Pageable pageable);
	
	long countByEmailLikeIgnoreCaseOrNameLikeIgnoreCase(String emailLike, String nameLike);
}
