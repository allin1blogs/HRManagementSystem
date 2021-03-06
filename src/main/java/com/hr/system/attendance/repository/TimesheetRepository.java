package com.hr.system.attendance.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hr.system.attendance.bean.TimesheetAccessBean;

@Repository
public interface TimesheetRepository extends JpaRepository<TimesheetAccessBean, Long> {

	/*
	 * @Query("FROM timesheet t WHERE STR_TO_DATE(t.date, '%a, %c %b %Y %k:%i:%s') BETWEEN :startTime AND :endTime"
	 * ) List<TimesheetAccessBean> findDataWithDateRange(
	 * 
	 * @Param("startTime") Date fromDate, @Param("endTime") Date toDate);
	 */
	
}
