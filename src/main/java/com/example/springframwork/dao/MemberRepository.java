package com.example.springframwork.dao;

import com.example.springframwork.dto.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {


    Member findMemberByName(String name);

}