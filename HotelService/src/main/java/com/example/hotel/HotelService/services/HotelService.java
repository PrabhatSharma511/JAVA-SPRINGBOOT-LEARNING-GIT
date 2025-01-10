package com.example.hotel.HotelService.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.hotel.HotelService.entities.Hotel;

@Service
public interface HotelService {

	Hotel create(Hotel hotel);
	
	List<Hotel> getAll();
	
	Hotel getById(String id);
	
}
