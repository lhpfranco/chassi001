package br.com.platao.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.platao.domain.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	 
	Optional<Student> findById(Long id);

}
