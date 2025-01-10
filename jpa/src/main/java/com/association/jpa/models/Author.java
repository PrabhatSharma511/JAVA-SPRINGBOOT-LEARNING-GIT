package com.association.jpa.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
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
@NamedQueries(
{@NamedQuery(name="Author.findByNamedQueryAge",query="select a from Author a where age>=:age"),
@NamedQuery(name ="Author.updateAge",query = "update Author a set a.age=:age")}
)
//@Table(name = "AUTHOR_TBL")
public class Author extends BaseEntity {

//	@Id
//	@GeneratedValue
//	(strategy = GenerationType.TABLE,generator = "author_id_gen")
//	@SequenceGenerator(
//			name = "author_sequence",
//			sequenceName = "author_sequence",
//			allocationSize = 1
//			)
//	@TableGenerator(
//			name = "author_id_gen",
//			table = "id_generator",
//			pkColumnName = "id_name",
//			valueColumnName  = "id_value",
//			allocationSize = 1
//			)
//	private Integer id;
	
//	@Column(name = "f_name",length = 35)
	private String firstName;
	
	private String lastName;
	
	@Column(unique = true,nullable = false)
	private String email;
	
	private Integer age;
	
//	@Column(updatable = false,nullable = false)
//	private LocalDateTime createdAt;
//	
//	@Column(insertable = false)
//	private LocalDateTime lastModified;
	
	@ManyToMany(mappedBy = "authors",fetch = FetchType.EAGER)
	private List<Course> courses;
	
	
}
