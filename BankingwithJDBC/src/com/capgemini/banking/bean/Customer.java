package com.capgemini.banking.bean;

public class Customer {
	private String name,emailId;
	private String phoneNo;
	private String doorNo,city,pinCode,country;
	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String string) {
		this.phoneNo = string;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String zipCode) {
		this.pinCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", emailId=" + emailId + ", phoneNo=" + phoneNo + ", doorNo=" + doorNo
				+ ", city=" + city + ", pinCode=" + pinCode + ", country=" + country + "]";
	}
	
	
	
}