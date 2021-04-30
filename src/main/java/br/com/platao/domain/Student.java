package br.com.platao.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Details about the student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The unique id of the student")
	private Long id;
	
	@ApiModelProperty(notes = "The student's name")
	private String firstName;
	
	@ApiModelProperty(notes = "The student's last name")
	private String lastName;
	
	protected Student() {}
	
	public Student(String firstName, String lastName) {
	    this.firstName = firstName;
	    this.lastName = lastName;
	  }
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return String.format(
	        "Student[id=%d, firstName='%s', lastName='%s']",
	        id, firstName, lastName);
	  }
	
}
