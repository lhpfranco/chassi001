package br.com.platao.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.platao.domain.Student;
import br.com.platao.domain.StudentPath;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/students")
public class StudentsResource {
	
	ConcurrentMap<Long,Student> students = new ConcurrentHashMap<>();
	
	
	@GetMapping("/{id}")
	@ApiOperation(value="Finds students by id", notes="Provide an id to look up specific student", response=Student.class)
	public Student getStudent(@ApiParam(value="ID value for the student you need to retrieve", required=true) @PathVariable Long id) {
		 return students.get(id);
	}
	
	@GetMapping("/")
	@ApiOperation(value="Returns all students", notes="Return all enrolled students", response=Student.class)
	public List<Student> getAllStudents() {
		return new ArrayList<Student>(students.values());
	}
	
	@PostMapping("/")
	@ApiOperation(value="Add a new student", notes="Add a new student", response=Student.class)
	public Student addStudent(@RequestBody Student student) {
		students.put(student.getId(),student);
		return student;
	}
	
	@PutMapping("/")
	@ApiOperation(value="Updates an student", notes="Provide information for an existent student", response=Student.class)
	public Student updateVerbPut(@RequestBody Student student) {
		students.replace(student.getId(), student);
		return student;
	}
	
	@PatchMapping("/")
	@ApiOperation(value="Updates the city of the student", notes="Updates only the city of the student", response=Student.class)
	public Student updateVerbPatch(@RequestBody StudentPath studentPath) throws Exception {
		try {
			Student student_update = students.get(studentPath.getId());
			student_update.setCity(studentPath.getCity());
			students.replace(student_update.getId(), student_update);
			return students.get(studentPath.getId());
		}catch(Exception e) {
			throw new Exception("test for error message: " + e.getMessage() );
		}
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value="Delete an existing student", notes="Delete an existing student", response=ResponseEntity.class)
	public ResponseEntity<Student> deleteStudent(@ApiParam(value="ID value for the student you need to delete", required=true) @PathVariable Long id) {
		students.remove(id);
		return new ResponseEntity<Student>(HttpStatus.OK);
	}

}
