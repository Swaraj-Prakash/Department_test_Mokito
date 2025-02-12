package com.meproject.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meproject.entity.Department;
import com.meproject.exception.DepartmentNotFoundExcetion;
import com.meproject.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}
	@Override
	public List<Department> fetchDepartmentList() {
		return departmentRepository.findAll();
	}
	@Override
	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundExcetion {
		Optional<Department>department = departmentRepository.findById(departmentId);
		if(!department.isPresent()) {
			throw new DepartmentNotFoundExcetion("Department Not found");
		}
		return department.get();
	}
	@Override
	public void deletDepartmentById(Long departmentId) {
		
		departmentRepository.deleteById(departmentId);
	}
	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		Department depDB=departmentRepository.findById(departmentId).get();
		if(Objects.nonNull(department.getDepartmentName())&&
				!"".equalsIgnoreCase(department.getDepartmentName())) {
			depDB.setDepartmentName(department.getDepartmentName());
		}
		if(Objects.nonNull(department.getDepartmentAddress())&&
				!"".equalsIgnoreCase(department.getDepartmentAddress())) {
			depDB.setDepartmentAddress(department.getDepartmentAddress());
		}
		if(Objects.nonNull(department.getDepartmentCode())&&
				!"".equalsIgnoreCase(department.getDepartmentCode())) {
			depDB.setDepartmentCode(department.getDepartmentCode());
		}
		
		return departmentRepository.save(depDB);
	}
	@Override
	public Department fetchDepartmentByName(String departmentName) {
		return departmentRepository.findByDepartmentName(departmentName);
	}

}
