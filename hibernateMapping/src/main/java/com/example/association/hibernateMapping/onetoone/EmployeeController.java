//package com.example.association.hibernateMapping.onetoone;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
////@RestController
//public class EmployeeController {
//
//	@Autowired
//	EmployeeRepository empRepository;
//	@Autowired
//	AdressRepository adressRepository;
//	
//	@GetMapping("/employees")
//	public List<Employee> getAllEmployees() {
//		return empRepository.findAll();
//	}
//	
//	@PostMapping("/employees")
//	public Employee insertEmployee(@RequestBody Employee empoyee) {
//		if(empoyee.getAdress()!=null) {
//			empoyee.getAdress().setEmployee(empoyee);
//		}
//		
//		return empRepository.save(empoyee);
//	}
//}
