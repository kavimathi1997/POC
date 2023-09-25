package com.POC.MemberManagement.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.POC.MemberManagement.Entity.BankAccount;
import com.POC.MemberManagement.Entity.Member;
import com.POC.MemberManagement.Repo.BankRepo;
import com.POC.MemberManagement.Repo.MemberRepo;
import com.POC.MemberManagement.Request.BankDetails;
import com.POC.MemberManagement.Response.BankResponse;
import com.POC.MemberManagement.Response.MemberResponse;

@Service
public class BankDetailsServiceImpl implements BankDetailsService{
	
	@Autowired 
	private BankRepo bankRepo;
	
	@Autowired
	private MemberRepo memberRepo;

	@Override
	public void add(List<BankDetails> bankRequest, Long id) {
		List<BankAccount> bankAccList = new ArrayList<>();
		Member member = memberRepo.findById(id).orElseThrow(() -> new RuntimeException("Member not found"));
		bankRequest.forEach(bankReq ->
		{
			BankAccount bankAcc =new BankAccount();
			bankAcc.setAccountNumber(bankReq.getAccountNumber());
			bankAcc.setAccountHolderName(bankReq.getAccountHolderName());
			bankAcc.setBankName(bankReq.getBankName());
			bankAcc.setAccountCountry(bankReq.getAccountCountry());
			bankAcc.setMember(member);
			bankAccList.add(bankAcc);
		});
		
		bankRepo.saveAll(bankAccList);
	}

	@Override
	public boolean edit(BankDetails bankReq, Long id) {
		BankAccount bankAcc =new BankAccount();
		boolean flag=false;
		Member member = memberRepo.findById(id).orElseThrow(() -> new RuntimeException("Member not found"));
		List<BankAccount> bankList = member.getBankDetails();
		for(BankAccount bl:bankList)
		{
			if(bankReq.getAccountNumber().equals(bl.getAccountNumber()))
			{
				flag=true;
			}
		}
		if(flag)
		{
			bankAcc.setAccountNumber(bankReq.getAccountNumber());
			bankAcc.setAccountHolderName(bankReq.getAccountHolderName());
			bankAcc.setBankName(bankReq.getBankName());
			bankAcc.setAccountCountry(bankReq.getAccountCountry());
			bankAcc.setMember(member);
			bankRepo.save(bankAcc);
			return flag;
		}
		else
			return flag;
	}

	@Override
	public void delete(Long id) {
		Member member = memberRepo.findById(id).orElseThrow(() -> new RuntimeException("Member not found"));
		List<BankAccount> banAcc = member.getBankDetails();
		banAcc.removeAll(banAcc);
		memberRepo.save(member);
		
	}

	@Override
	public List<BankResponse> get(Long id) {
		List<BankResponse> responseList = new ArrayList<>();
		List<BankAccount> bankAcc = bankRepo.findAll();
		bankAcc.forEach(bank ->
		{
			if(bank.getMember().getId()==id)
			{
				BankResponse response = new BankResponse();
				response.setAccountNumber(bank.getAccountNumber());
				response.setAccountHolderName(bank.getAccountHolderName());
				response.setBankName(bank.getBankName());
				response.setAccountCountry(bank.getAccountCountry());
				responseList.add(response);
			}
		});
		return responseList;
	}

	@Override
	public List<MemberResponse> getMembers(String country) {
		List<BankAccount> bankAcc =  bankRepo.findAll();
		List<Long> store = new ArrayList<>(); 
		List<MemberResponse> memList = new ArrayList<>();
		for(BankAccount b:bankAcc)
		{
			if(b.getAccountCountry().equalsIgnoreCase(country) && (!store.contains(b.getMember().getId())))
			{
				MemberResponse m =new MemberResponse();
				m.setId(b.getMember().getId());
				store.add(b.getMember().getId());
				m.setName(b.getMember().getName());
				m.setKycLevel(b.getMember().getKycLevel());
				m.setMobileNumber(b.getMember().getMobileNumber());
				m.setMobileNumberVerfied(true);
				m.setCreatedDate(b.getMember().getCreatedDate());
				memList.add(m);
				
			}
		}
		return memList;

	}
	
}
