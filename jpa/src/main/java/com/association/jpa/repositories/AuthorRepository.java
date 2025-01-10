package com.association.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.association.jpa.models.Author;

import jakarta.transaction.Transactional;

public interface AuthorRepository extends JpaRepository<Author, Integer>,JpaSpecificationExecutor<Author> {
	
	@Transactional
	@Modifying
	@Query("update Author a set a.age=:age where id=:id")
	int updateAuthor(int id,int age);
	
	List<Author> findByNamedQueryAge(@Param("age") int age);
	
	@Transactional
	@Modifying
	void updateAge(@Param("age") int age);

}
