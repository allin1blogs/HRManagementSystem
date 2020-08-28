package com.hr.system.payroll.service;

import java.util.List;

import com.hr.system.payroll.bean.CtcHistoryAccessBean;
import com.hr.system.payroll.bean.EmployeeCTCAccessBean;

public interface PayrollService {

	void addEmployeeAllowances(String LogonId,Long allowanceTypeId);

	void addEmployeeSalary(EmployeeCTCAccessBean salary);

	List<CtcHistoryAccessBean> salaryRevision();

	List<EmployeeCTCAccessBean> currentSalaryRevision();

	
}
