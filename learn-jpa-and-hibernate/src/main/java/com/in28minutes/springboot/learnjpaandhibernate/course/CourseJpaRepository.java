package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {

	@PersistenceContext   //this is more specific while autowired will also work
	private EntityManager entityManager;
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public Course findById(long id) {
		return entityManager.find(Course.class,id);
	}
	
	public void deleteById(long id) {
		Course crs = entityManager.find(Course.class,id);
		entityManager.remove(crs);
	}
	
}
