package com.example.rating.service;

import java.util.List;

import com.example.rating.entities.Rating;

public interface RatingService {

	Rating create(Rating rating);
	
	List<Rating> getAll();
	
	List<Rating> getByUserId(String userId);
	
	List<Rating> getByHotelId(String hotelId);
	
}
