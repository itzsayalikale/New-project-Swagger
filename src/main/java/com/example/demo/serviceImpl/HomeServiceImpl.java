package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.HomeRepository;
import com.example.demo.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private HomeRepository hr;

	@Override
	public String addData(Student student) {
		if(student!=null) {
			hr.save(student);
			return "data added";
		}
		else
			return "Data not received";
	}

	@Override
	public List<Student> getAllData() {
		List<Student> getData = hr.findAll();
		return getData;
	}

	@Override
	public Student getSingleData(int id) {
		if(hr.existsById(id)) {
			Optional<Student> response = hr.findById(id);
			if(response!=null) {
				return response.get();
			}
			else
				return null;
		}
		else
			return null;
			
	}

	@Override
	public String deleteData(int id) {
		if(hr.existsById(id)) {
			hr.deleteById(id);
			return "data deleted";
		}
		else
			return "ID not found to delete";
	}

	@Override
	public String updateData(Student student, int id) {
		if(hr.existsById(id)) {
			hr.save(student);
			return "data updated";
		}
		else
			return "ID not found to update..!!";
	}
	
	
}
