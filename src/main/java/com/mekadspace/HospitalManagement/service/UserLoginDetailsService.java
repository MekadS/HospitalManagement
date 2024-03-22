package com.mekadspace.HospitalManagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mekadspace.HospitalManagement.mapper.UserLoginUserDetails;
import com.mekadspace.HospitalManagement.model.UserLogin;
import com.mekadspace.HospitalManagement.repository.UserLoginRepo;

public class UserLoginDetailsService implements UserDetailsService {

	@Autowired
	private UserLoginRepo userLoginRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<UserLogin> userLogin = userLoginRepo.findByUsername(username);

		return userLogin.map(UserLoginUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("Username Not Found"));

	}
}