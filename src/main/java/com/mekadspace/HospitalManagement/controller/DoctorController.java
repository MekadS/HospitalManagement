package com.mekadspace.HospitalManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mekadspace.HospitalManagement.model.Doctor;
import com.mekadspace.HospitalManagement.service.DoctorService;
import com.mekadspace.HospitalManagement.service.DepartmentService;
//import com.mekadspace.HospitalManagement.model.Department;

@Controller
public class DoctorController {
    
	//IMPORTANT: ADD @Autowired FOR EACH SERVICE
	@Autowired
		private DoctorService doctorService;
	@Autowired
		private DepartmentService departmentService;
	 
	@GetMapping("/doctor/list")
	public String viewHomePage(Model doctor) {
	    List<Doctor> listDoctor = doctorService.listAll();
	    doctor.addAttribute("listDoctor", listDoctor);
	    System.out.println("••• Getting Doctors List •••");    
	    return "/doctor/list";
	}
	
	@GetMapping("/doctor/create")
	public String add(Model model) {
	    model.addAttribute("Doctor", new Doctor());
	    
	    // IMPORTANT: TO SHOW DEPARTMENTS IN A DROPDOWN MENU
	    List<com.mekadspace.HospitalManagement.model.Department> depts = departmentService.listAll();
	    model.addAttribute("depts", depts);
	    
	    return "/doctor/create";
	}
	
	@RequestMapping(value = "/doctor/save", method = RequestMethod.POST)
	public String saveDoctor(@ModelAttribute("Doctor") Doctor Doctor) {
	    doctorService.save(Doctor);
	    return "redirect:/doctor/list";
	}
	
	@RequestMapping("/doctor/edit/{id}")
	public ModelAndView showEditDoctorPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/doctor/create");
	    Doctor Doctor = doctorService.get(id);
	    mav.addObject("Doctor", Doctor);
	    return mav;
	}
	
	@RequestMapping("/doctor/delete/{id}")
	public String deleteDoctor(@PathVariable(name = "id") int id) {
	    doctorService.delete(id);
	    return "redirect:/doctor/list";
	}
}