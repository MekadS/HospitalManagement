package com.mekadspace.HospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mekadspace.HospitalManagement.model.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
}