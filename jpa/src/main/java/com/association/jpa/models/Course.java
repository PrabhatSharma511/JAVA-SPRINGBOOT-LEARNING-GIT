package com.association.jpa.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@AllArgsConstructor
@SuperBuilder
@Entity
class Course extends BaseEntity{

//	@Id
//	@GeneratedValue
//	private Integer id;
	
	private String name;
	
	private String description;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "authors_courses",
			joinColumns = {
					@JoinColumn(name="course_id")
			},
			inverseJoinColumns = {
					@JoinColumn(name="author_id")
			}
			)
	private List<Author> authors;
	
	@OneToMany(mappedBy = "course")
	private List<Section> sections;
}
