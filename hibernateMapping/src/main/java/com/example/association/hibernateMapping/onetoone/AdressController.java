//package com.example.association.hibernateMapping.onetoone;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
////@RestController
//public class AdressController {
//
//	@Autowired
//	AdressRepository adressRepo;
//	
//	@PostMapping("/adress")
//	public Adress insertAdress(@RequestBody Adress adress) {
//		return adressRepo.save(adress);
//	}
//	
//	@GetMapping("/adress")
//	public List<Adress> getAllAdress(){
//		return adressRepo.findAll();
//	}
//	
//}
