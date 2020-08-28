package com.hr.system.payroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.system.employee.repository.EmployeeRepository;
import com.hr.system.payroll.repository.AllowancesTransRepository;

@Service
public class PfServiceImpl implements PfService {

	@Autowired
	AllowancesTransRepository allowancesTransRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Long calculatePf(Long basicPay, boolean pfFlag) {

		Long pf = null;

		if (pfFlag == true) {
			pf = (basicPay * 12) / 100;
			if (pf > 21600)
				return 21600L;
			return pf;
		}
		return pf;

	}

	@Override
	public Long calculateBasicSalary(long CTC, boolean metroCity) {
		Long BasicSalary = null;
		if (metroCity == true) {
			BasicSalary = (CTC * 50) / 100;
		} else {
			BasicSalary = (CTC * 40) / 100;
		}
		return BasicSalary;
	}

	@Override
	public Long calculateHRA(Long basicSalaryYearly,long percentage) {
		Long hra = (basicSalaryYearly * percentage) / 100;
		return hra;
	}

	@Override
	public Long calculateESI(Long grossPay) {
		Long esi;
		if(grossPay<21000) {
		esi=(long) (grossPay*0.0075);
		}
		else
			esi=(long) (21000*0.0075);
		return esi;
	}

	@Override
	public Long calculateConveyance(boolean b) {
		Long convey;
		if(!b) {
			convey=1600*12L;
		return	convey;
		}
		else {
			return 1600L;
		}
		
	}

}
