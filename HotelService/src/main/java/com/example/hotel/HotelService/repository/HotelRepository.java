package com.example.hotel.HotelService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel.HotelService.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

	
	
}
