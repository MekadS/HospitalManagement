package com.mekadspace.HospitalManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mekadspace.HospitalManagement.model.UserLogin;


public interface UserLoginRepo extends JpaRepository<UserLogin, Long> {

//	Optional<UserLogin> findByUsername(String username);
	UserLogin findByUsername(String username);
}