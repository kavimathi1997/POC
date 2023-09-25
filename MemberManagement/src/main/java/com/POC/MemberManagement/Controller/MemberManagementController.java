package com.POC.MemberManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.POC.MemberManagement.Entity.Member;
import com.POC.MemberManagement.Response.MemberResponse;
import com.POC.MemberManagement.Service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberManagementController {
	
	@Autowired
	private MemberService memberService;
	
	//Rest API to add members
	@PostMapping("/add")
	public ResponseEntity<String> addMember(@RequestBody List<Member> memberReq)
	{
		memberService.add(memberReq);
		return ResponseEntity.status(HttpStatus.CREATED).body("Members added sucessfully");
	}
	
	//Rest API to edit a Member
	@PutMapping("/edit")
	public ResponseEntity<String> editMember(@RequestBody Member member)
	{
		boolean flag =memberService.edit(member);
		if(flag)
		{
			return ResponseEntity.status(HttpStatus.OK).body("Member edited sucessfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Member trying to edit, is not available in DB");
		}
		
		
	}
	
	//Rest API to delete all members 
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteMember()
	{
		memberService.delete();
		return ResponseEntity.status(HttpStatus.OK).body("All Members were deleted sucessfully");
	}
	
	
	//Rest API to list all members
	@GetMapping("/get")
	public List<MemberResponse> getMember()
	{
		return memberService.get();
	}
}
