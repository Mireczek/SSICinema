package com.ssi.cinema.backend;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssi.cinema.backend.data.entity.Repertoire;

public interface RepertoireRepository extends JpaRepository<Repertoire, Long> {
	
}
