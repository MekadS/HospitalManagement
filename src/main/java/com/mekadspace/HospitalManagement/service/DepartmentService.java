package com.mekadspace.HospitalManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mekadspace.HospitalManagement.model.Department;
import com.mekadspace.HospitalManagement.repository.DepartmentRepository;

@Service
public class DepartmentService {
    
    @Autowired
    private DepartmentRepository departmentRepo;
    

//    public void generateFakeDepartment(int count) {
//	    for (int i = 0; i < count; i++) {
//	    	departmentRepo.save(new Department());
//	    }
//	}
    
    public List<Department> listAll() {
        return departmentRepo.findAll();
    }
     
    public void save(Department dept) {
        departmentRepo.save(dept);
    }
     
    public Department get(long id) {
        return departmentRepo.findById(id).get();
    }
     
    public void delete(long id) {
        departmentRepo.deleteById(id);
    }

}