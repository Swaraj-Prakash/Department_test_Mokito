package com.meproject.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.meproject.entity.Department;
import com.meproject.exception.DepartmentNotFoundExcetion;
import com.meproject.service.DepartmentService;

@RestController
public class DeparmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	private final Logger logger= LoggerFactory.getLogger(DeparmentController.class);
	
	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department department) {
		logger.info("Inside saveDepartment of DepartmentController");
		return departmentService.saveDepartment(department);
		
	}
	@GetMapping("/departments")
	public List<Department>fetchDepartmentList(){
		logger.info("Inside featchDepartment of DepartmentController");
		return departmentService.fetchDepartmentList();
	}
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) 
			throws DepartmentNotFoundExcetion {
		
		return departmentService.fetchDepartmentById(departmentId);
		
	}
	@DeleteMapping("/departments/{id}")
	public String deletDepartmentById(@PathVariable("id") Long departmentId) {
		departmentService.deletDepartmentById(departmentId);
		return "Department Deleted successfully";
	}
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId ,@RequestBody Department department) {
		return departmentService.updateDepartment(departmentId,department);
	}
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
		return departmentService.fetchDepartmentByName(departmentName);
	}

}
