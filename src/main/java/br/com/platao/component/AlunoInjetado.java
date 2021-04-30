package br.com.platao.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.platao.domain.Student;

@Component
public class AlunoInjetado {
	
	public Student student;
	
	@Autowired
	public AlunoInjetado (Student studentLuis) {
		this.student = studentLuis;
	}
	
}
