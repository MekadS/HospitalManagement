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

@Controller
public class DoctorController {
    
     @Autowired
        private DoctorService service;
	     
     	@GetMapping("/doctor/list")
        public String viewHomePage(Model model) {
            List<Doctor> listDoctor = service.listAll();
            model.addAttribute("listDoctor", listDoctor);
            System.out.println("••• Getting Doctors List •••");    
            return "/doctor/list";
        }

        @GetMapping("/doctor/create")
        public String add(Model model) {
            model.addAttribute("Doctor", new Doctor());
            return "/doctor/create";
        }

        @RequestMapping(value = "/doctor/save", method = RequestMethod.POST)
        public String saveDoctor(@ModelAttribute("Doctor") Doctor Doctor) {
            service.save(Doctor);
            return "redirect:/doctor/list";
        }

        @RequestMapping("/doctor/edit/{id}")
        public ModelAndView showEditDoctorPage(@PathVariable(name = "id") int id) {
            ModelAndView mav = new ModelAndView("/doctor/create");
            Doctor Doctor = service.get(id);
            mav.addObject("Doctor", Doctor);
            return mav;
            
        }
        @RequestMapping("/doctor/delete/{id}")
        public String deleteDoctor(@PathVariable(name = "id") int id) {
            service.delete(id);
            return "redirect:/doctor/list";
        }
}