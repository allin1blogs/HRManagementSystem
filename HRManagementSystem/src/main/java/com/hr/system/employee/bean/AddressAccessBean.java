package com.hr.system.employee.bean;

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
@Table(name="Address")
public class AddressAccessBean {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="AddressId")
	private Long addressId;
	
	@Column(name="EmployeeId")
	private Long employeeId;
	
	@Column(name="AddressType")
	private String addressType;
	
	@Column(name="PersonTitle")
	private String personTitle;
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="MiddleName")
	private String middleName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="BusinessTitle")
	private String businessTitle;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="Age")
	private String age;
	
	@Column(name="Caste")
	private String caste;
	
	@Column(name="Nationality")
	private String nationality;
	
	@Column(name="MartialStatus")
	private String martialStatus;
	
	@Column(name="Phone1")
	private String phone1;	
	
	@Column(name="Phone2")
	private String phone2;
	
	@Column(name="Email1")
	private String email1;
	
	@Column(name="Email2")
	private String email2;
	
	@Column(name="Address1")
	private String address1;
	
	@Column(name="Address2")
	private String address2;	
	
	@Column(name="Address3")
	private String address3;
	
	@Column(name="City")
	private String city;
	
	@Column(name="StateId")
	private String stateId;
	
	@Column(name="CountryId")
	private String countryId;
	
	@Column(name="Pincode")
	private String pincode;	
	
	@Column(name="LastCreate")
	private String lastCreate;
	
	@Column(name="OfficeAddressId")
	private String officeAddressId;
	
	@Column(name="Field1")
	private String field1;
	
	@Column(name="Field2")
	private String field2;
	
	@Column(name="Field3")
	private String field3;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getPersonTitle() {
		return personTitle;
	}

	public void setPersonTitle(String personTitle) {
		this.personTitle = personTitle;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBusinessTitle() {
		return businessTitle;
	}

	public void setBusinessTitle(String businessTitle) {
		this.businessTitle = businessTitle;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateId() {
		return stateId;
	}

	public void setStateId(String stateId) {
		this.stateId = stateId;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getLastCreate() {
		return lastCreate;
	}

	public void setLastCreate(String lastCreate) {
		this.lastCreate = lastCreate;
	}

	public String getOfficeAddressId() {
		return officeAddressId;
	}

	public void setOfficeAddressId(String officeAddressId) {
		this.officeAddressId = officeAddressId;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}	
}
