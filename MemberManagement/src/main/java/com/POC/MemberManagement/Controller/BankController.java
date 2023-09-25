package com.POC.MemberManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.POC.MemberManagement.Request.BankDetails;
import com.POC.MemberManagement.Response.BankResponse;
import com.POC.MemberManagement.Response.MemberResponse;
import com.POC.MemberManagement.Service.BankDetailsService;

@RestController
@RequestMapping("/Bank")
public class BankController {
	
	@Autowired
	private BankDetailsService bankDetailsService;
	
	//Rest API to add list of bank details for given member id
	@PostMapping("/add/{id}")
	public ResponseEntity<String> addBank(@RequestBody List<BankDetails> bankReq,@PathVariable Long id) {
		bankDetailsService.add(bankReq,id);
		return ResponseEntity.status(HttpStatus.CREATED).body("bank details added sucessfully");
	}
	
	//Rest API to edit a bank detail for given member id
	@PutMapping("/edit/{id}")
	public ResponseEntity<String> editBank(@RequestBody BankDetails bankReq,@PathVariable Long id)
	{
		boolean flag = bankDetailsService.edit(bankReq,id);
		if(flag)
		{
			return ResponseEntity.status(HttpStatus.OK).body("Bank detail edited sucessfully");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Account number trying to edit, is not available in DB");
		}
	}
	
	//Rest API to delete bank details for given member id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteMember(@PathVariable Long id)
	{
		bankDetailsService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("bank details deleted sucessfully");
	}
	
	//Rest API to get bank details for given member id
	@GetMapping("/get/{id}")
	public List<BankResponse> getMember(@PathVariable Long id)
	{
		List<BankResponse> getMember = bankDetailsService.get(id);
		return getMember;
	}
	
	//API to list the Members details, who have bank accounts in given country
	
	@GetMapping("/getMembers/{country}")
	public List<MemberResponse> getMembersForCountry(@PathVariable String country)
	{
		List<MemberResponse> memres = bankDetailsService.getMembers(country);
		return memres;
	} 

}
