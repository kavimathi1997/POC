package com.POC.MemberManagement.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.POC.MemberManagement.Repo.MemberRepo;
import com.POC.MemberManagement.Response.MemberResponse;
import com.POC.MemberManagement.Entity.BankAccount;
import com.POC.MemberManagement.Entity.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberRepo memberRepo;
	
	@Override
	public void add(List<Member> memberReqt) {
		List<Member> memList = new ArrayList<>();
		memberReqt.forEach(memberReq ->
		{
			Member addmem = new Member();
			List<BankAccount> membank = memberReq.getBankDetails();
			addmem.setId(memberReq.getId());
			addmem.setName(memberReq.getName());
			if(memberReq.getKycLevel().equals("Basic") || memberReq.getKycLevel().equals("PRO") || memberReq.getKycLevel().equals("Not Verified"))
			{
				addmem.setKycLevel(memberReq.getKycLevel());
			}
			if(memberReq.isMobileNumberVerfied()) {
				addmem.setMobileNumber(memberReq.getMobileNumber());
				addmem.setMobileNumberVerfied(true);
			}
			else {
				addmem.setMobileNumberVerfied(false);
			}
			List<BankAccount> bankList = new ArrayList<>();
			for(BankAccount mb : membank)
			{				
				BankAccount bacc = new BankAccount();
				bacc.setAccountNumber(mb.getAccountNumber());
				bacc.setAccountHolderName(mb.getAccountHolderName());
				bacc.setBankName(mb.getBankName());
				bacc.setAccountCountry(mb.getAccountCountry());
				bacc.setMember(addmem);
				bankList.add(bacc);
				
			}
			addmem.setBankDetails(bankList);
			memList.add(addmem);
		});
		memberRepo.saveAll(memList);
	}

	@Override
	public boolean edit(Member member) {
		Member editmem = new Member();
		List<BankAccount> bankList = new ArrayList<>();
		List<BankAccount> membank = member.getBankDetails();
		boolean flag =false;
		
		/*checks whether passed memberId is already present in DB or not.
		if it is present, member details will be edited else no content status code will be passed
		 as response*/
		Optional<Member> checkMemId = memberRepo.findById(member.getId());
		if(checkMemId.isPresent())
		{
			editmem.setId(member.getId());
			editmem.setName(member.getName());
			if(member.getKycLevel().equals("Basic") || member.getKycLevel().equals("PRO") || member.getKycLevel().equals("Not Verified"))
			{
				editmem.setKycLevel(member.getKycLevel());
			}
			if(member.isMobileNumberVerfied()) {
				editmem.setMobileNumber(member.getMobileNumber());
				editmem.setMobileNumberVerfied(true);
			}
			else
			{
				editmem.setMobileNumberVerfied(false);
			}
			editmem.setCreatedDate(member.getCreatedDate());
			membank.forEach(mb ->
			{
				BankAccount bacc = new BankAccount();
				bacc.setAccountNumber(mb.getAccountNumber());
				bacc.setAccountHolderName(mb.getAccountHolderName());
				bacc.setBankName(mb.getBankName());
				bacc.setAccountCountry(mb.getAccountCountry());
				bacc.setMember(editmem);
				bankList.add(bacc);
				
			});
			
			editmem.setBankDetails(bankList);
			memberRepo.save(editmem);
			return flag=true;
			
		}
		else
		{
			return flag;
		}
	}

	@Override
	public void delete() {
		memberRepo.deleteAll();
		
	}

	@Override
	public List<MemberResponse> get() {
		List<MemberResponse> memList =new ArrayList<>();
		 List<Member> mem =memberRepo.findAll();
		 mem.forEach(m->
		 {
			 MemberResponse response = new MemberResponse();
			 response.setId(m.getId());
			 response.setName(m.getName());
			 response.setKycLevel(m.getKycLevel());
			 response.setMobileNumber(m.getMobileNumber());
			 if(m.isMobileNumberVerfied())
			 {
				 response.setMobileNumberVerfied(true);
			 }
			 else {
				 response.setMobileNumberVerfied(false);
			 }
			 response.setCreatedDate(m.getCreatedDate());
			 memList.add(response);
			 
		 });
		return memList;
		
	}

}
