package com.in28minutes.springboot.learnjpaandhibernate.springdataJPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;

@Repository
public interface CourseSpringDataJPARepository extends JpaRepository<Course,Long>{

	List<Course> findByAuthor(String author); //name of property should be same as in class definition
	List<Course> findByName(String Course);
	
}
