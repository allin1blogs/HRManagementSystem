package com.hr.system.payroll.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hr.system.payroll.service.PayrollService;
import com.hr.system.payroll.service.PfService;

@Controller
public class CTCCalulatorControllerCmd {

	@Autowired
	PayrollService payrollService;
	
	@Autowired
	PfService pfService;

	
	@RequestMapping(value = "calBasicSalary", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Map<String,Long> calculateBasicSalary(@RequestBody Long ctc) {
		System.out.println("ctc "+ctc);
		
		Long basicSalaryYearly,pfYearly,hraYearly,allowances,grossPay,esiYearly,otherYearly,annualRefSalary,tdsYearly,conveyanceYearly;
		
		basicSalaryYearly=pfService.calculateBasicSalary(ctc, false);
		pfYearly=pfService.calculatePf(basicSalaryYearly, true);
		hraYearly=pfService.calculateHRA(basicSalaryYearly, 50);
		conveyanceYearly=pfService.calculateConveyance(true);
		
		otherYearly=ctc-(basicSalaryYearly+hraYearly+conveyanceYearly);
		
		allowances=hraYearly+otherYearly+conveyanceYearly;
		grossPay=basicSalaryYearly+allowances;
		
		esiYearly=pfService.calculateESI(grossPay);
		tdsYearly=0L;
		annualRefSalary=grossPay-(pfYearly+esiYearly+tdsYearly);
		
		Map<String,Long> ctcMAP=new HashMap<String,Long>();
		ctcMAP.put("basicSalaryYearly", basicSalaryYearly);
		ctcMAP.put("pfYearly", pfYearly);
		ctcMAP.put("hraYearly", hraYearly);
		ctcMAP.put("conveyanceYearly", conveyanceYearly);
		ctcMAP.put("allowances", allowances);
		ctcMAP.put("grossPay", grossPay);
		ctcMAP.put("esiYearly", esiYearly);
		ctcMAP.put("otherYearly", otherYearly);
		ctcMAP.put("tdsYearly", tdsYearly);
		ctcMAP.put("annualRefSalary", annualRefSalary);
		
		
		
		return ctcMAP;
		
	}
}
