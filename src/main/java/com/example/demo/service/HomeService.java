package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface HomeService {

	public String addData(Student student);

	public List<Student> getAllData();

	public Student getSingleData(int id);

	public String deleteData(int id);

	public String updateData(Student student, int id);

}
