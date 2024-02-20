package com.mekadspace.HospitalManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mekadspace.HospitalManagement.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	
}