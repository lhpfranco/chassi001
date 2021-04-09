package br.com.platao.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Class responsible to change the student's city")
public class StudentPath {
	
	@ApiModelProperty(notes = "The unique id of the student")
	private Long id;
	
	@ApiModelProperty(notes = "The student's city of residence")
	private String city;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
