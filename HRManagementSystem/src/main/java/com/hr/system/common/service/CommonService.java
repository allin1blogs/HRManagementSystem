package com.hr.system.common.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.hr.system.payroll.bean.EmployeeCTCAccessBean;

public interface CommonService {

	void savePreviousSalary(Optional<EmployeeCTCAccessBean> empSalary) ;

	String uploadFiles(MultipartFile csv) throws IOException;

	
}
