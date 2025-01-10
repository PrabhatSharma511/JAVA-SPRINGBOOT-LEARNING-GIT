package com.association.jpa.models;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@NoArgsConstructor
@Data
@AllArgsConstructor
@SuperBuilder
public class BaseEntity {
	
	@Id
	@GeneratedValue
	private Integer id;

	private LocalDateTime createdAt;
	
	private LocalDateTime lastModifiedAt;
	
	private String createdBy;
	
	private String lastModifiedBy;
	
}
