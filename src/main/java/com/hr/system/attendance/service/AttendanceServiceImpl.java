package com.hr.system.attendance.service;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hr.system.attendance.bean.AttendanceAccessBean;
import com.hr.system.attendance.bean.TimesheetAccessBean;
import com.hr.system.attendance.repository.AttendanceRepository;
import com.hr.system.attendance.repository.TimesheetRepository;
import com.hr.system.common.files.Utils;
import com.hr.system.payroll.bean.EmployeeCTCAccessBean;

@Service
public class AttendanceServiceImpl implements AttendanceService {
	
	@Autowired
	Utils utils;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	TimesheetRepository timesheetRepository;
	
	@Autowired
	AttendanceRepository attendanceRepository;
	
	@Override
	public List<AttendanceAccessBean> attendanceRevision() {
		List<TimesheetAccessBean> timesheetData=timesheetRepository.findAll();
		List<AttendanceAccessBean> attendanceData=new ArrayList<AttendanceAccessBean>();
		Iterator<TimesheetAccessBean> dataitr=timesheetData.iterator();
		while(dataitr.hasNext()) {
			TimesheetAccessBean data=dataitr.next();
			AttendanceAccessBean attendanceAccessBean=new AttendanceAccessBean();
			attendanceAccessBean.setEmployeeId(data.getEmployeeId());
			attendanceAccessBean.setProjectId(data.getProjectId());
			attendanceAccessBean.setManagerId(data.getManagerId());
			attendanceAccessBean.setDate(data.getDate());
			LocalTime t1 = LocalTime.parse(data.getCheckOut());
			LocalTime t2 = LocalTime.parse(data.getCheckIn());
			int hourt1=t1.getHour();
			int mint1=t1.getMinute();
			int hourt2=t2.getHour();
			int mint2=t2.getMinute();
			LocalTime updatedTime = LocalTime.of(hourt1, mint1).minusHours(hourt2).minusMinutes(mint2);
			attendanceAccessBean.setWorkingHours(updatedTime.toString());
			attendanceAccessBean.setOverTime(LocalTime.of(updatedTime.getHour(), updatedTime.getMinute()).minusHours(8).minusMinutes(00).toString());
			attendanceAccessBean.setWorkingShiftId(1L);
			attendanceAccessBean.setTimeSheetId(data.getTimeSheetId());
			attendanceRepository.save(attendanceAccessBean);
			attendanceData.add(attendanceAccessBean);
		}
		return attendanceData;
	}

	/*
	 * @Override public void exportData(String fromDate, String toDate) {
	 * List<TimesheetAccessBean>
	 * data=timesheetRepository.findDataWithDateRange(Date.valueOf(fromDate),
	 * Date.valueOf(toDate)); System.out.println(data); }
	 */
	
	@Transactional
	public void exportData(String fromDate, String toDate) {

		String historyQuery = "FROM timesheet WHERE date BETWEEN ? AND ?";

		
		 Query q=entityManager.createQuery(historyQuery, TimesheetAccessBean.class).setParameter(1, fromDate).setParameter(2, toDate);
		  Object[] data = (Object[])q.getSingleResult();
		 
		
		
		
	}


	
}
