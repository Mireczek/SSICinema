package com.ssi.cinema.backend.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssi.cinema.backend.RoomStatusRepository;
import com.ssi.cinema.backend.data.entity.Room;
import com.ssi.cinema.backend.data.entity.RoomStatus;

@Service
public class RoomStatusService extends CrudService<RoomStatus> {
	
	private final RoomStatusRepository roomStatusRepository;
	
	@Autowired
	public RoomStatusService(RoomStatusRepository roomStatusRepository) {
		this.roomStatusRepository = roomStatusRepository;
	}
	
	public RoomStatus findByRoomAndDate(Room room, Date date) {
		return getRepository().findByRoomAndDate(room, date);
	}
	
	@Override
	protected RoomStatusRepository getRepository() {
		return roomStatusRepository;
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
