package com.mekadspace.HospitalManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import javax.persistence.Id;	//OLD package

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String Departmentname;
    private String location;
    public Department() {

    }
    public Department(Long id, String Departmentname, String location) {
    
        this.id = id;
        this.Departmentname = Departmentname;
        this.location = location;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDepartmentname() {
        return Departmentname;
    }
    public void setDepartmentname(String Departmentname) {
        this.Departmentname = Departmentname;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}