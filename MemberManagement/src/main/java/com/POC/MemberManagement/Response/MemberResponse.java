package com.POC.MemberManagement.Response;

import java.util.Date;



public class MemberResponse {
	
	private Long id;
	private String name;
	private String kycLevel;
	private String mobileNumber;
	private boolean mobileNumberVerfied;
	private Date createdDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKycLevel() {
		return kycLevel;
	}
	public void setKycLevel(String kycLevel) {
		this.kycLevel = kycLevel;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public boolean isMobileNumberVerfied() {
		return mobileNumberVerfied;
	}
	public void setMobileNumberVerfied(boolean mobileNumberVerfied) {
		this.mobileNumberVerfied = mobileNumberVerfied;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	

}
