package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
