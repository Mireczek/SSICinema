package com.ssi.cinema.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssi.cinema.backend.ReservationRepository;
import com.ssi.cinema.backend.data.entity.Reservation;

@Service
public class ReservationService extends CrudService<Reservation> {
	
	private final PasswordEncoder passwordEncoder;
	
	private final ReservationRepository reservationRepository;
	
	@Autowired
	public ReservationService(ReservationRepository reservationRepository, PasswordEncoder passwordEncoder) {
		this.reservationRepository = reservationRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public Reservation findByEmail(String email) {
		return getRepository().findByEmail(email);
	}
	
	@Override
	protected ReservationRepository getRepository() {
		return reservationRepository;
	}
	
	public String encodePassword(String value) {
		return passwordEncoder.encode(value);
	}
	
	@Override
	@Transactional
	public Reservation save(Reservation entity) {
		return super.save(entity);
	}
	
	@Override
	@Transactional
	public void delete(long reservationId) {
		super.delete(reservationId);
	}
	
	@Override
	public long countAnyMatching(Optional<String> filter) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public Page<Reservation> findAnyMatching(Optional<String> filter, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
