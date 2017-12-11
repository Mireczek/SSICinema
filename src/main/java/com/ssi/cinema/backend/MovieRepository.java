package com.ssi.cinema.backend;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssi.cinema.backend.data.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	Movie findByName(String name);
	
}
