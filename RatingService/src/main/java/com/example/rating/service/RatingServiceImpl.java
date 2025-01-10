package com.example.rating.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rating.entities.Rating;
import com.example.rating.exception.ResourceNotFoundException;
import com.example.rating.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepository repo;

	@Override
	public Rating create(Rating rating) {
		return repo.save(rating);
	}

	@Override
	public List<Rating> getAll() {
		return repo.findAll();
	}

	@Override
	public List<Rating> getByHotelId(String id) {
		return repo.findByHotelId(id);
	}

	@Override
	public List<Rating> getByUserId(String userId) {
		return repo.findByUserId(userId);
	}


}
