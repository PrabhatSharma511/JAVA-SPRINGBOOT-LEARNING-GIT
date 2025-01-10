package com.example.user.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.user.service.Repository.UserRepository;
import com.example.user.service.entities.Hotel;
import com.example.user.service.entities.Rating;
import com.example.user.service.entities.User;
import com.example.user.service.exception.ResourceNotFoundException;
import com.example.user.service.externalServices.HotelService;
import com.example.user.service.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository repo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	HotelService hotelService;

	@Override
	public User saveUser(User user) {
		String id = UUID.randomUUID().toString();
		user.setUserId(id);
		repo.save(user);
		return null;
	}

	@Override
	public List<User> getAllUser() {
		return repo.findAll();
	}

	@Override
	public User getUser(String userId) {
		User user = repo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user with give id not exist"));
		Rating[] ratingsArray = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		List<Rating> ratings = Arrays.stream(ratingsArray).toList();
		List<Rating> newRatings = ratings.stream().map(rating->{
			
//			ResponseEntity<Hotel> hotel = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(),Hotel.class);
//			rating.setHotel(hotel.getBody());
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		user.setRatings(newRatings);
		return user;
	}

}
