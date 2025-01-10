package com.association.jpa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
public class Lecture extends BaseEntity{

//	@Id
//	@GeneratedValue
//	private Integer id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="section_id")
	private Section section;
	
	@OneToOne
	@JoinColumn(name = "resource_id")
	private Resource resource;
	
}
