package com.mekadspace.HospitalManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mekadspace.HospitalManagement.model.Doctor;
import com.mekadspace.HospitalManagement.repository.DoctorRepository;

@Service
public class DoctorService {
    
    @Autowired
    private DoctorRepository DoctorRepo;
    

//    public void generateFakeDoctor(int count) {
//	    for (int i = 0; i < count; i++) {
//	    	DoctorRepo.save(new Doctor());
//	    }
//	}
    
    public List<Doctor> listAll() {
        return DoctorRepo.findAll();
    }
     
    public void save(Doctor doc) {
    	System.out.println(doc.toString());
        DoctorRepo.save(doc);
    }
     
    public Doctor get(long id) {
        return DoctorRepo.findById(id).get();
    }
     
    public void delete(long id) {
        DoctorRepo.deleteById(id);
    }

}