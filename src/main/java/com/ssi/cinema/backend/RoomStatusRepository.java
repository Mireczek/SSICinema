package com.ssi.cinema.backend;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssi.cinema.backend.data.entity.Room;
import com.ssi.cinema.backend.data.entity.RoomStatus;

public interface RoomStatusRepository extends JpaRepository<RoomStatus, Long> {
	
	RoomStatus findByRoom(Room room);
	
}
