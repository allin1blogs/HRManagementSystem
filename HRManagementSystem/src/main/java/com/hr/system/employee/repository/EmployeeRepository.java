package com.hr.system.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hr.system.employee.bean.EmployeeAccessBean;

public interface EmployeeRepository extends JpaRepository<EmployeeAccessBean, Long> {

	EmployeeAccessBean findByLogonId(String logonId);
	EmployeeAccessBean findByEmployeeId(Long employeeId);
	
	

}
