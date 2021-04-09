package br.com.platao.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the student")
public class Student {
	
	@ApiModelProperty(notes = "The unique id of the student")
	private Long id;
	
	@ApiModelProperty(notes = "The student's name")
	private String name;
	
	@ApiModelProperty(notes = "The student's city of residence")
	private String city;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
