package com.POC.MemberManagement.Response;



public class BankResponse {
	
	private Long accountNumber;
	private String bankName;
	private String accountCountry;
	private String accountHolderName;
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
