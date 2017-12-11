package com.ssi.cinema.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssi.cinema.backend.MovieRepository;
import com.ssi.cinema.backend.data.entity.Movie;

@Service
public class MovieService extends CrudService<Movie> {
	
	private final PasswordEncoder passwordEncoder;
	
	private final MovieRepository movieRepository;
	
	@Autowired
	public MovieService(MovieRepository movieRepository, PasswordEncoder passwordEncoder) {
		this.movieRepository = movieRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public Movie findByName(String name) {
		return getRepository().findByName(name);
	}
	
	@Override
	protected MovieRepository getRepository() {
		return movieRepository;
	}
	
	public String encodePassword(String value) {
		return passwordEncoder.encode(value);
	}
	
	@Override
	@Transactional
	public Movie save(Movie entity) {
		return super.save(entity);
	}
	
	@Override
	@Transactional
	public void delete(long movieId) {
		super.delete(movieId);
	}
	
	@Override
	public long countAnyMatching(Optional<String> filter) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public Page<Movie> findAnyMatching(Optional<String> filter, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
