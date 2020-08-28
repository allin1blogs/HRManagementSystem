package com.hr.system.common.files;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("keys")
public class Keys {
	
	@Value("#{'${TimesheetHeader}'.split(',')}")
	private String[] timesheetHeader;

	public String[] getTimesheetHeader() {
		return timesheetHeader;
	}

	public void setTimesheetHeader(String[] timesheetHeader) {
		this.timesheetHeader = timesheetHeader;
	}
	
}