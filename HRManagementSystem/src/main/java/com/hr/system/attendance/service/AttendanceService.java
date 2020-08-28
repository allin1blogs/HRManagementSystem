package com.hr.system.attendance.service;

import java.util.List;

import com.hr.system.attendance.bean.AttendanceAccessBean;

public interface AttendanceService {

	List<AttendanceAccessBean> attendanceRevision();

	void exportData(String fromDate, String toDate);

}
