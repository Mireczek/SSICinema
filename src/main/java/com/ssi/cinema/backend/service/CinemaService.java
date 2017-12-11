package com.ssi.cinema.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssi.cinema.backend.CinemaRepository;
import com.ssi.cinema.backend.data.entity.Cinema;

@Service
public class CinemaService extends CrudService<Cinema> {
	
	private static final String MODIFY_LOCKED_USER_NOT_PERMITTED = "Cinema has been locked and cannot be modified or deleted";
	
	private final PasswordEncoder passwordEncoder;
	
	private final CinemaRepository cinemaRepository;
	
	@Autowired
	public CinemaService(CinemaRepository cinemaRepository, PasswordEncoder passwordEncoder) {
		this.cinemaRepository = cinemaRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public Cinema findByEmail(String email) {
		return getRepository().findByEmail(email);
	}
	
	@Override
	public Page<Cinema> findAnyMatching(Optional<String> filter, Pageable pageable) {
		if (filter.isPresent()) {
			String repositoryFilter = "%" + filter.get() + "%";
			return getRepository().findByEmailLikeIgnoreCaseOrNameLikeIgnoreCaseOrRoleLikeIgnoreCase(repositoryFilter,
					repositoryFilter, repositoryFilter, pageable);
		}
		else {
			return getRepository().findAll(pageable);
		}
	}
	
	@Override
	public long countAnyMatching(Optional<String> filter) {
		if (filter.isPresent()) {
			String repositoryFilter = "%" + filter.get() + "%";
			return getRepository().countByEmailLikeIgnoreCaseOrNameLikeIgnoreCase(repositoryFilter, repositoryFilter);
		}
		else {
			return getRepository().count();
		}
	}
	
	@Override
	protected CinemaRepository getRepository() {
		return cinemaRepository;
	}
	
	public String encodePassword(String value) {
		return passwordEncoder.encode(value);
	}
	
	@Override
	@Transactional
	public Cinema save(Cinema entity) {
		return super.save(entity);
	}
	
	@Override
	@Transactional
	public void delete(long cinemaId) {
		super.delete(cinemaId);
	}
	
}
