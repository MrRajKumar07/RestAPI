package com.Postman.APItesting;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	StudentRepository srepo;
	
//Creating a Tables with following data......for my first CRUD Operation APItesting...........!
		
	@PostMapping("/save")
	public void savedata(@RequestBody Student student)
	{
		srepo.save(student);
	
	}
	@GetMapping("/all")
	public List<Student> showdata()
	{
		return srepo.findAll();
	
	}
	@PatchMapping("/update/{id}")
	public ResponseEntity<Student> update(@PathVariable int id,@RequestBody Student stu)
	{
		Optional<Student> student=srepo.findById(id);
		student.get().setName(stu.getName());
		student.get().setCity(stu.getCity());
		student.get();
		student.get();
		Student Stu1=srepo.save(student.get());
		ResponseEntity<Student>re=new ResponseEntity<>(Stu1,HttpStatus.OK);
		return re;
	}
}
