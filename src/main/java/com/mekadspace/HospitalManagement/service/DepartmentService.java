package com.mekadspace.HospitalManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mekadspace.HospitalManagement.model.Department;
import com.mekadspace.HospitalManagement.repository.DepartmentRepository;

@Service
public class DepartmentService {
    
    @Autowired
    private DepartmentRepository repo;
    
    public List<Department> listAll() {
        return repo.findAll();
    }
     
    public void save(Department dept) {
        repo.save(dept);
    }
     
    public Department get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }

}