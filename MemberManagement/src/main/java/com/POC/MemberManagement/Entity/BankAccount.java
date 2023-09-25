package com.POC.MemberManagement.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="BankAccount")
public class BankAccount {
	@Id
	private Long accountNumber;
	@Column
	private String bankName;
	@Column
	private String accountCountry;
	@Column
	private String accountHolderName;
	
	@ManyToOne
	@JoinColumn(name="memberId")
	private Member member;


	public Member getMember() {
		return member;
	} 

	public void setMember(Member member) {
		this.member = member;
	} 

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}


	public String getAccountCountry() {
		return accountCountry;
	}

	public void setAccountCountry(String accountCountry) {
		this.accountCountry = accountCountry;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	
	
	

}
