package com.hr.system.employee.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.hr.system.payroll.bean.AllowancesAccessBean;
import com.hr.system.payroll.bean.DeductionsAccessBean;
import com.hr.system.payroll.bean.EcisAccessBean;
import com.hr.system.payroll.bean.GratuityAccessBean;
import com.hr.system.payroll.bean.LoanAccessBean;
import com.hr.system.payroll.bean.PayrollAccessBean;
import com.hr.system.payroll.bean.PfAccessBean;
import com.hr.system.payroll.bean.SalaryAccessBean;
import com.hr.system.payroll.bean.TaxAccessBean;

/*
 *	@Author
 *	Preeti Rani 
*/

@Entity
@Table(name = "Employee")
public class EmployeeAccessBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EmployeeId")
	private Long employeeId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employeeAccessBean")
	private List<SalaryAccessBean> salaryAccessBean;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employeeAccessBean")
	private List<PayrollAccessBean> payrollAccessBean;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employeeAccessBean")
	private List<AllowancesAccessBean> allowancesAccessBean;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employeeAccessBean")
	private List<DeductionsAccessBean> deductionsAccessBean;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employeeAccessBean")
	private List<EcisAccessBean> ecisAccessBean;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employeeAccessBean")
	private List<GratuityAccessBean> gratuityAccessBean;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employeeAccessBean")
	private List<LoanAccessBean> loanAccessBean;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employeeAccessBean")
	private List<PfAccessBean> pfAccessBean;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employeeAccessBean")
	private List<TaxAccessBean> taxAccessBean;

	@Column(name = "LogonId")
	private String logonId;

	@Column(name = "LogonPassword")
	private String logonPassword;

	@Column(name = "EmployeeCode")
	private String employeeCode;

	@Column(name = "Status")
	private String status;

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getLogonId() {
		return logonId;
	}

	public void setLogonId(String logonId) {
		this.logonId = logonId;
	}

	public String getLogonPassword() {
		return logonPassword;
	}

	public void setLogonPassword(String logonPassword) {
		this.logonPassword = logonPassword;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<SalaryAccessBean> getSalaryAccessBean() {
		return salaryAccessBean;
	}

	public void setSalaryAccessBean(List<SalaryAccessBean> salaryAccessBean) {
		this.salaryAccessBean = salaryAccessBean;
	}

	public List<PayrollAccessBean> getPayrollAccessBean() {
		return payrollAccessBean;
	}

	public void setPayrollAccessBean(List<PayrollAccessBean> payrollAccessBean) {
		this.payrollAccessBean = payrollAccessBean;
	}

	public List<AllowancesAccessBean> getAllowancesAccessBean() {
		return allowancesAccessBean;
	}

	public void setAllowancesAccessBean(List<AllowancesAccessBean> allowancesAccessBean) {
		this.allowancesAccessBean = allowancesAccessBean;
	}

	public List<DeductionsAccessBean> getDeductionsAccessBean() {
		return deductionsAccessBean;
	}

	public void setDeductionsAccessBean(List<DeductionsAccessBean> deductionsAccessBean) {
		this.deductionsAccessBean = deductionsAccessBean;
	}

	public List<EcisAccessBean> getEcisAccessBean() {
		return ecisAccessBean;
	}

	public void setEcisAccessBean(List<EcisAccessBean> ecisAccessBean) {
		this.ecisAccessBean = ecisAccessBean;
	}

	public List<GratuityAccessBean> getGratuityAccessBean() {
		return gratuityAccessBean;
	}

	public void setGratuityAccessBean(List<GratuityAccessBean> gratuityAccessBean) {
		this.gratuityAccessBean = gratuityAccessBean;
	}

	public List<LoanAccessBean> getLoanAccessBean() {
		return loanAccessBean;
	}

	public void setLoanAccessBean(List<LoanAccessBean> loanAccessBean) {
		this.loanAccessBean = loanAccessBean;
	}

	public List<PfAccessBean> getPfAccessBean() {
		return pfAccessBean;
	}

	public void setPfAccessBean(List<PfAccessBean> pfAccessBean) {
		this.pfAccessBean = pfAccessBean;
	}

	public List<TaxAccessBean> getTaxAccessBean() {
		return taxAccessBean;
	}

	public void setTaxAccessBean(List<TaxAccessBean> taxAccessBean) {
		this.taxAccessBean = taxAccessBean;
	}

}
