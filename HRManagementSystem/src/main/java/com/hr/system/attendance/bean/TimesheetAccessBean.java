package com.hr.system.attendance.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 *	@Author
 *	Preeti Rani 
*/

@Entity
@Table(name = "timesheet")
public class TimesheetAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TimeSheetId")
	private Long TimeSheetId;

	@Column(name = "EmployeeId")
	private Long EmployeeId;

	@Column(name = "ProjectId")
	private Long ProjectId;

	@Column(name = "ManagerId")
	private Long ManagerId;

	@Column(name = "Date")
	private String Date;

	@Column(name = "Day")
	private String Day;

	@Column(name = "CheckIn")
	private String CheckIn;

	@Column(name = "CheckOut")
	private String CheckOut;

	@Column(name = "RawTime")
	private String RawTime;

	@Column(name = "RoundTime")
	private String RoundTime;

	@Column(name = "Status")
	private String Status;

	@Column(name = "LeavesId")
	private Long LeaveId;

	@Column(name = "HolidayId")
	private Long HolidayId;

	public Long getTimeSheetId() {
		return TimeSheetId;
	}

	public void setTimeSheetId(Long timeSheetId) {
		TimeSheetId = timeSheetId;
	}

	public Long getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(Long employeeId) {
		EmployeeId = employeeId;
	}

	public Long getProjectId() {
		return ProjectId;
	}

	public void setProjectId(Long projectId) {
		ProjectId = projectId;
	}

	public Long getManagerId() {
		return ManagerId;
	}

	public void setManagerId(Long managerId) {
		ManagerId = managerId;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getDay() {
		return Day;
	}

	public void setDay(String day) {
		Day = day;
	}

	public String getCheckIn() {
		return CheckIn;
	}

	public void setCheckIn(String checkIn) {
		CheckIn = checkIn;
	}

	public String getCheckOut() {
		return CheckOut;
	}

	public void setCheckOut(String checkOut) {
		CheckOut = checkOut;
	}

	public String getRawTime() {
		return RawTime;
	}

	public void setRawTime(String rawTime) {
		RawTime = rawTime;
	}

	public String getRoundTime() {
		return RoundTime;
	}

	public void setRoundTime(String roundTime) {
		RoundTime = roundTime;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Long getLeaveId() {
		return LeaveId;
	}

	public void setLeaveId(Long leaveId) {
		LeaveId = leaveId;
	}

	public Long getHolidayId() {
		return HolidayId;
	}

	public void setHolidayId(Long holidayId) {
		HolidayId = holidayId;
	}

}
