package com.mekadspace.HospitalManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Doctor {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String doctorname;
	private String email;
	private String phonenumber;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
    private Department department;

	@OneToOne
	@JoinColumn(name = "userLoginId")
	private UserLogin userLoginId;
}