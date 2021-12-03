package com.tch.tool.domain;

public class Bank {
	private String id;
	private String bankName;
	private String type;
	private String city;
	private String state;
	private String zipCode;	
	
	public Bank(String id, String bankName, String type, String city, String state, String zipCode) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.type = type;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
    public String toString() {
        return "Bank [Name=" + bankName + ", Type=" + type + ", City=" + city + ", State=" + state + ", Zip code=" + zipCode + "]";
    }	
}
