package com.POC.MemberManagement.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.POC.MemberManagement.Entity.Member;

@Repository
public interface MemberRepo extends JpaRepository<Member,Long> {

}
