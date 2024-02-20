package com.mekadspace.HospitalManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Doctor {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String doctorname;

	@ManyToOne
//    @JoinColumn(name = "department_id")
//	@Column(insertable=false, updatable=false)
	@JoinColumn(name = "department.id")
    private Department department;
	
	public Doctor() {
		
	}
	
	public Doctor(Long id, String doctorname, Department department) {
		super();
		this.id = id;
		this.doctorname = doctorname;
		this.department = department;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDoctorname() {
		return doctorname;
	}
	
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
}