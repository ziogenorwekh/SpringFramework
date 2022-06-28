package com.example.springframwork.controller;


import com.example.springframwork.dto.Member;
import com.example.springframwork.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class MemberController {

    final MemberService memberService;
    List<Member> members;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        members = new ArrayList<>();
    }

    @PostConstruct
    public void defaultMember() {
        log.info("PostConstruct 실행");
        Member member = new Member("lsek", "spring@io.a");
        Member member1 = new Member("lsek1", "spring@io.b");
        Member member2 = new Member("lsek2", "spring@io.c");
        Member member3 = new Member("lsek3", "spring@io.d");
        Member member4 = new Member("lsek4", "spring@io.e");
        Member member5 = new Member("lsek5", "spring@io.f");
        members.add(member);
        members.add(member1);
        members.add(member2);
        members.add(member3);
        members.add(member4);
        members.add(member5);
        memberService.saveAll(members);
    }

    @GetMapping("members/memberList")
    public String list(Model model) {
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
