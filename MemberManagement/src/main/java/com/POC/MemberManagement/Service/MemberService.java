package com.POC.MemberManagement.Service;


import java.util.List;

import com.POC.MemberManagement.Entity.Member;
import com.POC.MemberManagement.Response.MemberResponse;

public interface MemberService {
	
	public void add(List<Member> member);
	
	public boolean edit(Member member);
	
	public void delete();
	
	public List<MemberResponse> get();

}
