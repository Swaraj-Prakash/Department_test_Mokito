package com.meproject.service;

import java.util.List;

import com.meproject.entity.Department;
import com.meproject.exception.DepartmentNotFoundExcetion;

public interface DepartmentService {
	
	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundExcetion;

	public void deletDepartmentById(Long departmentId);

	public Department updateDepartment(Long departmentId, Department department);

	public Department fetchDepartmentByName(String departmentName);

}
