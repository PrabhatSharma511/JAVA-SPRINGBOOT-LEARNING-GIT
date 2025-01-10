package com.example.association.hibernateMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

	@Autowired
	AddressRepository addressRepoitory;
	
	@PostMapping("/address")
	public Address insertAdress(@RequestBody Address address) {
		return addressRepoitory.save(address);
	}
	
	@GetMapping("/adress")
	public List<Address> getAllAdress(){
		return addressRepoitory.findAll();
	}
	
}
