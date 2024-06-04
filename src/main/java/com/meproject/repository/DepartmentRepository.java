package com.meproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meproject.entity.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	public Department findByDepartmentName(String departmentName);
	//public Department findByDepartmentNameIgnorCase(String departmentName);

}
