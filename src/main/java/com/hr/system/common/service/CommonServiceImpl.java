package com.hr.system.common.service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.hr.system.attendance.bean.TimesheetAccessBean;
import com.hr.system.attendance.repository.TimesheetRepository;
import com.hr.system.common.files.Utils;
import com.hr.system.payroll.bean.EmployeeCTCAccessBean;
import com.hr.system.payroll.repository.EmployeeCTCRepository;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	EmployeeCTCRepository employeeCTCRepository;

	@Autowired
	TimesheetRepository timesheetRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private Utils utils;

	@Transactional
	public void savePreviousSalary(Optional<EmployeeCTCAccessBean> empSalary) {

		String historyQuery = "Insert into ctchistory(EmployeeId,Name,JoiningDate,IncrementDate,AnnualBasicSalary,AnnualFlexibleBenifits,AnnualRefSalary"
				+ ",PF,HRA,CONVEY,ESI,Gratuity,CTC,newCtc,Comments) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		entityManager.createNativeQuery(historyQuery).setParameter(1, empSalary.get().getEmployeeId())
				.setParameter(2, empSalary.get().getName()).setParameter(3, empSalary.get().getJoiningDate())
				.setParameter(4, empSalary.get().getIncrementDate())
				.setParameter(5, empSalary.get().getAnnualBasicSalary())
				.setParameter(6, empSalary.get().getAnnualFlexibleBenifits())
				.setParameter(7, empSalary.get().getAnnualRefSalary()).setParameter(8, empSalary.get().getPf())
				.setParameter(9, empSalary.get().getHra()).setParameter(10, empSalary.get().getConvey())
				.setParameter(11, empSalary.get().getEsi()).setParameter(12, empSalary.get().getGratuity())
				.setParameter(13, empSalary.get().getcTC()).setParameter(14, empSalary.get().getNewCtc())
				.setParameter(15, empSalary.get().getComments()).executeUpdate();
	}

	public String uploadFiles(MultipartFile csv) throws IOException {
		String flage = "Success";

		String timesheet;
		String[] csvHeader = utils.getHeader("timesheet");

		BufferedReader csvReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(csv.getBytes())));
		String line = "";
		int countLine = 0;
		boolean invalidLine = false;
		StringBuffer errors = new StringBuffer("Errors: \n");
		List<Integer> lines = new ArrayList<Integer>();
		outer: while ((line = csvReader.readLine()) != null) {
			if (csvHeader == null) {
				System.out.println("----------null haeder-------------");
				break;
			}
			String[] data = line.split(",");
			invalidLine = false;
			if (data.length != csvHeader.length) {
				if (countLine == 0) {
					flage = "Failed";
					errors.append("\tInvalid Csv Header!\n");
					break outer;
				} else {
					flage = "";
					errors.append("\tInvalid Line No.:" + countLine + ".\n");
					lines.add(countLine);
					invalidLine = true;
				}
			} else {
				if (countLine == 0) {
					for (int i = 0; i < csvHeader.length; i++) {
						if (!csvHeader[i].trim().equalsIgnoreCase(data[i].trim())) {
							flage = "Failed";
							errors.append("\tInvalid Header " + data[i].trim() + ". It should be as "
									+ csvHeader[i].trim() + ".\n");
							invalidLine = true;
						}
					}
					if (invalidLine)
						break outer;
				} else {
					if (!invalidLine) {
						for (int i = 0; i < data.length; i++) {
							if (data[i].trim().length() == 0) {
								flage = "";
								errors.append("\tLine No.:" + countLine + " contain empty entries.\n");
								invalidLine = true;
								lines.add(countLine);
								break;
							} else if (data[i].trim().indexOf(",") != -1)
								data[i] = data[i].trim().replace("@", ",");
						}

						if (!invalidLine) {
							boolean duplicateFlage = false;
							uploadTimesheet(data);
							if (duplicateFlage)
								errors.append("\tDuplicate entry for line no.:" + countLine + ".\n");
							if (invalidLine) {
								flage = "";
								errors.append("\tPdf File not found for line no.:" + countLine + ".\n");
								lines.add(countLine);
							}
						}
					}
				}
			}
			countLine++;
		}
		return flage;
	}

	private void uploadTimesheet(String[] data) {

		TimesheetAccessBean ts = new TimesheetAccessBean();
		ts.setEmployeeId(Long.valueOf(data[1]));
		ts.setProjectId(Long.valueOf(data[2]));
		ts.setManagerId(Long.valueOf(data[3]));
		ts.setDate(data[4]);
		ts.setDay(data[5]);
		ts.setCheckIn(data[6]);
		ts.setCheckOut(data[7]);
		ts.setRawTime(data[8]);// ???????
		ts.setRoundTime(data[9]);
		ts.setStatus(data[10]);
		ts.setLeaveId(Long.valueOf(data[11]));
		ts.setHolidayId(Long.valueOf(data[12]));

		timesheetRepository.save(ts);

	}

}
