package com.meproject.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.meproject.entity.Department;
import com.meproject.service.DepartmentService;

@WebMvcTest(DeparmentController.class)
class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private DepartmentService departmentService;
	
	private Department department;
	@BeforeEach
	void setUp() {
	
		department = Department.builder()
				.departmentName("IT")
				.departmentAddress("Bengalore")
				.departmentCode("IT-01")
				.departmentId(2L)
				.build();
		
	}
	@Test
	void saveDepartment() throws Exception {
	
	Department	inputDepartment = Department.builder()
				.departmentName("IT")
				.departmentAddress("Bangalore")
				.departmentCode("IT-01")
				.departmentId(2L)
				.build();
	
	Mockito.when(departmentService.saveDepartment(inputDepartment))
	.thenReturn(department);
	
	mockMvc.perform(MockMvcRequestBuilders.post("/departments")
			.contentType(MediaType.APPLICATION_JSON)
			.content(" {\r\n"
					+ "        \"departmentName\": \"IT\",\r\n"
					+ "        \"departmentAddress\": \"Bangalore\",\r\n"
					+ "        \"departmentCode\": \"IT-01\"\r\n"
					+ "    }"))
			.andExpect(MockMvcResultMatchers.status().isOk());
			
		
	}
	@Test
	void fetchDepartmentById() throws Exception {
		Mockito.when(departmentService.fetchDepartmentById(2L))
		.thenReturn(department);
		
		mockMvc.perform(get("/departments/2")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));
		
		
	}
	
}
