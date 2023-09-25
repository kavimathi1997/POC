package com.POC.MemberManagement.Service;

import java.util.List;


import com.POC.MemberManagement.Request.BankDetails;
import com.POC.MemberManagement.Response.BankResponse;
import com.POC.MemberManagement.Response.MemberResponse;


public interface BankDetailsService {

	public void add(List<BankDetails> bankReq,Long id);
	
	public boolean edit(BankDetails bankReq,Long id);
	
	public void delete(Long id);
	
	public List<BankResponse> get(Long id);
	
	public List<MemberResponse> getMembers(String country);
}
