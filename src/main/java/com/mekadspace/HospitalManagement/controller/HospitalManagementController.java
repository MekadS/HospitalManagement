package com.mekadspace.HospitalManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HospitalManagementController {

    @Autowired

	     @GetMapping("/index")
	     public String testPage() {
	         return "index";
	     }   
}