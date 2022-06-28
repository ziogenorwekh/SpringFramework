package com.example.springframwork.service;


import com.example.springframwork.dto.Member;
import com.example.springframwork.dao.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void save(Member member) {
        memberRepository.save(member);
    }

    public void saveAll(List<Member> members) {
        memberRepository.saveAll(members);
    }

    public Member findMemberByName(String name) {
        return memberRepository.findMemberByName(name);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }
}
