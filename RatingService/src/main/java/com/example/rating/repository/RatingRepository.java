package com.example.rating.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.rating.entities.Rating;

public interface RatingRepository extends MongoRepository<Rating,String>{

	List<Rating> findByHotelId(String id);
	
	List<Rating> findByUserId(String id);
	
}
