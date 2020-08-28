package com.hr.system.payroll.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.system.common.service.CommonService;
import com.hr.system.employee.bean.EmployeeAccessBean;
import com.hr.system.employee.repository.EmployeeRepository;
import com.hr.system.payroll.bean.AllowanceTransAccessBean;
import com.hr.system.payroll.bean.AllowancesAccessBean;
import com.hr.system.payroll.bean.CtcHistoryAccessBean;
import com.hr.system.payroll.bean.EmployeeCTCAccessBean;
import com.hr.system.payroll.repository.AllowancesTransRepository;
import com.hr.system.payroll.repository.CtcHistoryRepository;
import com.hr.system.payroll.repository.EmployeeCTCRepository;

@Service
public class PayrollServiceImpl implements PayrollService {

	@Autowired
	AllowancesTransRepository allowancesTransRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeCTCRepository employeeCTCRepository;
	
	@Autowired
	CtcHistoryRepository ctcHistoryRepository;

	@Autowired
	CommonService commonService;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addEmployeeAllowances(String LogonId, Long allowanceTypeId) {

		EmployeeAccessBean empAB = employeeRepository.findByLogonId("Preeti@gmail.com");

		AllowancesAccessBean allowancesAccessBean = new AllowancesAccessBean();
		allowancesAccessBean.setEmployeeAccessBean(empAB);
		allowancesAccessBean.setAllowancesAmt(1301L);
		allowancesAccessBean.setEffectiveDate(new Date());
		allowancesAccessBean.setEndDate(new Date());
		allowancesAccessBean.setAllowanceTypeId(allowanceTypeId);

		AllowanceTransAccessBean allowanceTransAccessBean = new AllowanceTransAccessBean();
		allowanceTransAccessBean.setAllowanceAmt(1201L);
		allowanceTransAccessBean.setAllowancesAccessBean(allowancesAccessBean);

		allowancesTransRepository.saveAndFlush(allowanceTransAccessBean);
	}

	@Override
	public void addEmployeeSalary(EmployeeCTCAccessBean salary) {
		Long employeeId = salary.getEmployeeId();
		boolean checkFlag = employeeCTCRepository.existsByEmployeeId(salary.getEmployeeId());
		if (checkFlag != true) {
			employeeCTCRepository.save(salary);
		} else {
			Optional<EmployeeCTCAccessBean> empSalary = employeeCTCRepository.findById(employeeId);
			commonService.savePreviousSalary(empSalary);
			employeeCTCRepository.deleteById(empSalary.get().getEmployeeId());
			employeeCTCRepository.save(salary);
			System.out.println(empSalary.get().getName());
		}

	}

	@Override
	public List<CtcHistoryAccessBean> salaryRevision() {
		 return ctcHistoryRepository.findAll();
	}

	@Override
	public List<EmployeeCTCAccessBean> currentSalaryRevision() {
		return employeeCTCRepository.findAll();
	}

}
