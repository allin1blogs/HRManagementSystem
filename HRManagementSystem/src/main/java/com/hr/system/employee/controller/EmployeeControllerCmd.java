package com.hr.system.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hr.system.employee.repository.EmployeeRepository;
import com.hr.system.payroll.bean.EmployeeCTCAccessBean;

@Controller
public class EmployeeControllerCmd {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@RequestMapping("/")
	void dashboard() {
		
	}
	
	@RequestMapping(value="/salary-structure",method=RequestMethod.GET)
	public String salaryStructure() {
		return "payroll/salary-structure";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.GET)
	public String save(@ModelAttribute("salary") EmployeeCTCAccessBean salary) {
		System.out.println("==============");
		System.out.println(salary.getAnnualFlexibleBenifits());
		return "0";
	}
}
