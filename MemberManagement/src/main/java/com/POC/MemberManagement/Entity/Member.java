package com.POC.MemberManagement.Entity;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name="Member")
public class Member {
	@Id
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String kycLevel;
	
	@Column
	private String mobileNumber;
	
	@Column
	private boolean mobileNumberVerfied;
	
	@CreationTimestamp
	private Date createdDate;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "member",orphanRemoval = true)
	private List<BankAccount> bankDetails;



	public Member(String name) {
		this.name = name;
	}
	
	public Member() {}

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

	public List<BankAccount> getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(List<BankAccount> bankDetails) {
		this.bankDetails = bankDetails;
	}

}
