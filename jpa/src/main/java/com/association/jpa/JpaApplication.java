package com.association.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import com.association.jpa.models.Author;
import com.association.jpa.models.Video;
import com.association.jpa.repositories.AuthorRepository;
import com.association.jpa.repositories.VideoRepository;
import com.association.jpa.specification.AuthorSpecification;
import com.github.javafaker.Faker;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository reposiotry,VideoRepository videoRepository) {
		return args->{
//			var video = Video.builder()
//					.name("abc")
//					.length(5).build();
//			videoRepository.save(video);
					
			for(int i=0;i<50;i++) {
				Faker faker = new Faker();
				var author = Author.builder()
				.firstName(faker.name().firstName())
				.lastName(faker.name().lastName())
				.age(faker.number().numberBetween(18, 80))
				.email(faker.name().username()+"@gmail.com")
				.build();
		reposiotry.save(author);
			}
			
			Author author = Author.builder()
					.id(1)
					.firstName("prabhat")
					.lastName("sharma")
					.email("cvv")
					.build();
//			reposiotry.save(author);
			
//			reposiotry.updateAuthor(1, 25);
			
//			reposiotry.findByNamedQueryAge(70).forEach(System.out::println);
//			reposiotry.updateAge(25);
			
			Specification<Author> spec = Specification
					.where(AuthorSpecification.hasAge(25)).and(AuthorSpecification.startsWith("M"));
			reposiotry.findAll(spec).forEach(System.out::println);
			
			
		};
		
		
	}

}
