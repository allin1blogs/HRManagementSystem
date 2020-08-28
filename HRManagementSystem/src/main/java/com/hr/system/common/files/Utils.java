package com.hr.system.common.files;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hr.system.employee.repository.EmployeeRepository;


@Controller
public class Utils
{
	@Autowired
	private Keys keys;
	
	@Autowired
	EmployeeRepository emp;
	
	public static String getDate()
	{
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
    	Date today = Calendar.getInstance().getTime();
    	return df.format(today);
	}
	
	@RequestMapping(value = "/attendance/getEmployeeDetails/{employeeId}", method = RequestMethod.GET)
	public void findEmployeeId(@PathVariable Long employeeId)
	{
		System.out.println(emp.findByEmployeeId(employeeId));
	}
	
	private  String getYear()
	{
		String year=null;
		year=getDate().substring(getDate().lastIndexOf("/")+1);
		return year;
	}
	
	private  String getMonth()
	{
		String mon=getDate().substring(getDate().indexOf(".")+1,getDate().lastIndexOf("."));
		if(mon.equals("01"))
			return "Jan";
		else if(mon.equals("02"))
			return "Feb";
		else if(mon.equals("03"))
			return "Mar";
		else if(mon.equals("04"))
			return "Apr";
		else if(mon.equals("05"))
			return "May";
		else if(mon.equals("06"))
			return "June";
		else if(mon.equals("07"))
			return "July";
		else if(mon.equals("08"))
			return "Aug";
		else if(mon.equals("09"))
			return "Sep";
		else if(mon.equals("10"))
			return "Oct";
		else if(mon.equals("11"))
			return "Nov";
		else
			return "Dec";
	}
	
	public static String getTime()
	{
		DateFormat df = new SimpleDateFormat("hh:mm:ss");
    	Date today = Calendar.getInstance().getTime();
    	return df.format(today);
	}
	
	public static String getMacAddress()
	{
		String mac=null;
		try
		{
			InetAddress ip=InetAddress.getLocalHost();
			NetworkInterface network=NetworkInterface.getByInetAddress(ip);
			byte[] m=network.getHardwareAddress();
			StringBuilder sb=new StringBuilder();
			for(int i=0;i<m.length;i++)
				sb.append(String.format("%02X%s",m[i],(i<m.length-1) ? "-" : ""));
			mac=sb.toString();
		}
		catch(Exception e)
		{mac="N.A.";}
		return mac;
	}
	
	public static String getDeviceName()
	{
		return System.getProperty("user.name");
	}
	
	public String[] getHeader(String header)
	{
			return keys.getTimesheetHeader();
	}
	
	
}