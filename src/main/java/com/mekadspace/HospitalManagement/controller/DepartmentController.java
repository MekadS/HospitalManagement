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

import com.mekadspace.HospitalManagement.model.Department;
import com.mekadspace.HospitalManagement.service.DepartmentService;

@Controller
public class DepartmentController {
    
     @Autowired
        private DepartmentService service;
	     
	     @GetMapping("/testpage")
	     public String testPage(Model model) {
	         return "/testpage";
	     }
     
     	@GetMapping("/department/list")
        public String viewHomePage(Model model) {
            List<Department> listDepartment = service.listAll();
            model.addAttribute("listDepartment", listDepartment);
            System.out.println("••• Getting Departments List •••");    
            return "/department/list";
        }

        @GetMapping("/department/create")
        public String add(Model model) {
            model.addAttribute("Department", new Department());
            return "/department/create";
        }

        @RequestMapping(value = "/department/save", method = RequestMethod.POST)
        public String saveDepartment(@ModelAttribute("Department") Department department) {
            service.save(department);
            return "redirect:/department/list";
        }

        @RequestMapping("/department/edit/{id}")
        public ModelAndView showEditDepartmentPage(@PathVariable(name = "id") int id) {
            ModelAndView mav = new ModelAndView("/department/create");
            Department department = service.get(id);
            mav.addObject("Department", department);
            return mav;
            
        }
        @RequestMapping("/department/delete/{id}")
        public String deleteDepartment(@PathVariable(name = "id") int id) {
            service.delete(id);
            return "redirect:/department/list";
        }
}