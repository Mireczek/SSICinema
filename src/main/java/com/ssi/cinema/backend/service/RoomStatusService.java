package com.ssi.cinema.backend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssi.cinema.backend.RoomStatusRepository;
import com.ssi.cinema.backend.data.entity.Room;
import com.ssi.cinema.backend.data.entity.RoomStatus;

@Service
public class RoomStatusService extends CrudService<RoomStatus> {
	
	private final PasswordEncoder passwordEncoder;
	
	private final RoomStatusRepository roomStatusRepository;
	
	@Autowired
	public RoomStatusService(RoomStatusRepository roomStatusRepository, PasswordEncoder passwordEncoder) {
		this.roomStatusRepository = roomStatusRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public RoomStatus findByRoom(Room room) {
		return getRepository().findByRoom(room);
	}
	
	@Override
	protected RoomStatusRepository getRepository() {
		return roomStatusRepository;
	}
	
	public String encodePassword(String value) {
		return passwordEncoder.encode(value);
	}
	
	@Override
	@Transactional
	public RoomStatus save(RoomStatus entity) {
		return super.save(entity);
	}
	
	@Override
	@Transactional
	public void delete(long roomStatusId) {
		super.delete(roomStatusId);
	}
	
	@Override
	public long countAnyMatching(Optional<String> filter) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public Page<RoomStatus> findAnyMatching(Optional<String> filter, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
