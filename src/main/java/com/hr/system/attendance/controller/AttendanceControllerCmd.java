package com.hr.system.attendance.controller;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hr.system.attendance.bean.AttendanceAccessBean;
import com.hr.system.attendance.service.AttendanceService;
import com.hr.system.common.service.CommonService;

@Controller
public class AttendanceControllerCmd {

	@Autowired
	CommonService commonService;

	@Autowired
	AttendanceService attendanceService;

	ModelAndView modelAndView = new ModelAndView();

	@RequestMapping(value = "/attendance/viewAttendanceLog", method = RequestMethod.GET)
	public ModelAndView viewAttendanceLog() {
		List<AttendanceAccessBean> allData = attendanceService.attendanceRevision();
		modelAndView.addObject("records", allData);
		modelAndView.setViewName("attendance/viewAttendanceLog");
		return modelAndView;
	}

	@RequestMapping(value = "/attendance/uploadAttendance", method = RequestMethod.POST)
	public String uploadBulk(@RequestParam("csv") MultipartFile csv) throws IOException {
		String flage = commonService.uploadFiles(csv);
		System.out.println(flage);
		return "/attendance/uploadAttendance";
	}

	@RequestMapping(value = "/attendance/exportData", method = RequestMethod.GET)
	public String exportData(@RequestParam("fromDate") String fromDate, @RequestParam("toDate") String toDate) {
		attendanceService.exportData(fromDate,toDate);
		return "";
	}
}
