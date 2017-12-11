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
	
	private static final String MODIFY_LOCKED_USER_NOT_PERMITTED = "RoomStatus has been locked and cannot be modified or deleted";
	
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
	public Page<RoomStatus> findAnyMatching(Optional<String> filter, Pageable pageable) {
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
	
}
