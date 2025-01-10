package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import com.in28minutes.springboot.learnjpaandhibernate.course.CourseJpaRepository;
import com.in28minutes.springboot.learnjpaandhibernate.springdataJPA.CourseSpringDataJPARepository;


@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	private CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJPARepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		repository.insert(new Course(1,"JAVA SPRING JPA","in28minutes"));
//		repository.insert(new Course(2,"AWS","in28minutes"));
//		repository.insert(new Course(3,"ReactJs","Lama Dev"));
		
		repository.save(new Course(1,"Java Spring Data JPA","in28minutes"));
		repository.save(new Course(2,"AWS","in28minutes"));
		repository.save(new Course(3,"ReactJs","Lama Dev"));
		
		repository.deleteById(2l);
//		
//		System.out.println(repository.findById(1l));
//		System.out.println(repository.findAll());
//		System.out.println(repository.findByAuthor("Lama Dev"));
		System.out.println(repository.findByName("AWS"));
	}
	
	

}
