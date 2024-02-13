package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.HomeService;

@RestController
@CrossOrigin("*")
@RequestMapping("/app/mainController")
public class HomeController {

@Autowired
 private HomeService homeservice;
	
	@PostMapping("/addData")
	public ResponseEntity<String> addData(@RequestBody Student student){
		String input=homeservice.addData(student);
		
		return new ResponseEntity<String>(input,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getData")
	public ResponseEntity<List<Student>> getAllData(){
		List<Student> list=homeservice.getAllData();
		
		return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/getSingleData/{id}")
	public ResponseEntity<Student> getSingleData(@PathVariable int id){
		Student stu=homeservice.getSingleData(id);
		return new ResponseEntity<Student>(stu,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteData/{id}")
	public ResponseEntity<String> deleteData(@PathVariable int id){
		String data=homeservice.deleteData(id);
		return new ResponseEntity<String>(data,HttpStatus.OK);
	}
	
	@PutMapping("/updateData/{id}")
	public ResponseEntity<String> updateData(@RequestBody Student student,@PathVariable int id){
		String response=homeservice.updateData(student,id);
		
		return new ResponseEntity<String>(response,HttpStatus.OK);
	}
}
