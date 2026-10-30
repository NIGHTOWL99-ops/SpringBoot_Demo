package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.info.google.advaced.auth.UserNotFoundException;
import com.example.demo.pojo.Department;
import com.example.demo.pojo.Employee;
import com.example.demo.repository.DepartmentRepository;

	@Service
	@Transactional
	public class DepartmentService {

	    private final DepartmentRepository departmentRepository;

	    public DepartmentService(DepartmentRepository departmentRepository) {
	        this.departmentRepository = departmentRepository;
	    }

	    // CREATE
	    public Department createDepartment(Department department) {
	        // Sync children references before saving
	        if (department.getEmployees() != null) {
	            department.getEmployees().forEach(employee -> employee.setDepartment(department));
	        }
	        return departmentRepository.save(department);
	    }

	    // READ ALL
	    public List<Department> getAllDepartments() {
	        return departmentRepository.findAll();
	    }

	    // READ ONE
	    public Department getDepartmentById(Long id) {
	        return departmentRepository.findById(id)
	                .orElseThrow(() -> new UserNotFoundException("Department not found with id: " + id));
	    }

	    // UPDATE
	    public Department updateDepartment(Long id, Department updatedDepartment) {
	        Department existingDept = getDepartmentById(id);
	        existingDept.setName(updatedDepartment.getName());

	        // Clear existing children to let orphanRemoval remove old references from database
	        existingDept.getEmployees().clear();
	        
	        if (updatedDepartment.getEmployees() != null) {
	            for (Employee emp : updatedDepartment.getEmployees()) {
	                existingDept.addEmployee(emp);
	            }
	        }
	        return departmentRepository.save(existingDept);
	    }

	    // DELETE
	    public void deleteDepartment(Long id) {
	        Department department = getDepartmentById(id);
	        departmentRepository.delete(department);
	    }
	}


