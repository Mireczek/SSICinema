package com.ssi.cinema.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssi.cinema.backend.RepertoireRepository;
import com.ssi.cinema.backend.data.entity.Repertoire;

@Service
public class RepertoireService extends CrudService<Repertoire> {
	
	private final RepertoireRepository repertoireRepository;
	
	@Autowired
	public RepertoireService(RepertoireRepository repertoireRepository) {
		this.repertoireRepository = repertoireRepository;
	}
	
	/*
	public Repertoire findByCinema(Cinema cinema) {
		return getRepository().findByCinema(cinema);
	}
	*/
	
	@Override
	protected RepertoireRepository getRepository() {
		return repertoireRepository;
	}
	
	@Override
	@Transactional
	public Repertoire save(Repertoire entity) {
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
	public Page<Repertoire> findAnyMatching(Optional<String> filter, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
