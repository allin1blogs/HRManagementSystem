package com.hr.system.payroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hr.system.payroll.bean.CtcHistoryAccessBean;
import com.hr.system.payroll.bean.EmployeeCTCAccessBean;
import com.hr.system.payroll.service.PayrollService;

@Controller
public class SalaryControllerCmd {

	@Autowired
	PayrollService payrollService;

	ModelAndView modelAndView = new ModelAndView();

	@RequestMapping(value = "payroll/addEmployeeSalary", method = RequestMethod.GET)
	public ModelAndView addEmployeeSalary(@ModelAttribute("emloyeeSalary") EmployeeCTCAccessBean emloyeeSalary,
			Model model) {

		model.addAttribute("emloyeeSalary", emloyeeSalary);
		payrollService.addEmployeeSalary(emloyeeSalary);

		modelAndView.setViewName("payroll/viewTax");
		return modelAndView;

	}

	@RequestMapping(value = "/addIncrementSalary", method = RequestMethod.GET)
	public String addIncrementSalary() {
		return "payroll/salaryIncrement";
	}

	@RequestMapping(value = "/salaryRevision", method = RequestMethod.GET)
	public ModelAndView salaryRevision() {
		List<CtcHistoryAccessBean> records = payrollService.salaryRevision();
		modelAndView.addObject("records",records);
		List<EmployeeCTCAccessBean> currentRecords = payrollService.currentSalaryRevision();
		modelAndView.addObject("currentRecords",currentRecords);
		modelAndView.setViewName("payroll/salaryRevision");
		return modelAndView;
	}

}
