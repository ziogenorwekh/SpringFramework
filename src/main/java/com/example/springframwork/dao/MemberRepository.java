package com.example.springframwork.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {


    public Member findMemberByName(String name);
}
