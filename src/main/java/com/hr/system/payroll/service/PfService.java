package com.hr.system.payroll.service;


public interface PfService {


	Long calculatePf(Long basicPay, boolean pfFlag);

	Long calculateBasicSalary(long CTC, boolean metroCity);

	Long calculateHRA(Long basicSalaryYearly, long percentage);

	Long calculateESI(Long grossPay);

	Long calculateConveyance(boolean b);

	
	
}
