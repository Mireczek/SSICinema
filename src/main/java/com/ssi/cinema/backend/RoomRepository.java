package com.ssi.cinema.backend;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssi.cinema.backend.data.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
	
	Room findByName(String name);
	
}
