package com.POC.MemberManagement.Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.POC.MemberManagement.Entity.BankAccount;

@Repository
public interface BankRepo extends JpaRepository<BankAccount, Long> {
	
}
