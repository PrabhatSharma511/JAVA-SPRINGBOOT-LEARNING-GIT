package com.example.hotel.HotelService.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.HotelService.entities.Hotel;
import com.example.hotel.HotelService.exceptions.ResourceNotFoundException;
import com.example.hotel.HotelService.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepository repo;

	@Override
	public Hotel create(Hotel hotel) {
		String id = UUID.randomUUID().toString();
		hotel.setId(id);
		return repo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return repo.findAll();
	}

	@Override
	public Hotel getById(String id) {
		return repo.findById(id).orElseThrow(()->new ResourceNotFoundException("hotel withgiven id not found"));
	}

	
	
}
