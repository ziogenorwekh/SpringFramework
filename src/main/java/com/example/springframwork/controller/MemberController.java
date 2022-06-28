package com.example.springframwork.controller;


import com.example.springframwork.dto.Member;
import com.example.springframwork.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@Slf4j
public class MemberController {

    private final MemberService memberService;
    private final MessageSource messages;
    List<Member> members;

    @Autowired
    public MemberController(MemberService memberService, MessageSource messages) {
        this.memberService = memberService;
        this.messages = messages;
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

    @GetMapping("/login")
    public String loginGet() {
        return "loginForm";
    }

    @PostMapping("/login")
    public String loginPost(String name, Model model, HttpSession session, RedirectAttributes attributes) {
        // name
        try {
            Member member = memberService.login(name);
            session.setAttribute("me", member);
            return list(model);
        } catch (NullPointerException e) {
            log.error(e.getLocalizedMessage() + ", 멤버가 없음!");
            attributes.addFlashAttribute("loginError", true);
            attributes.addFlashAttribute("errorName", name);
            session.setAttribute("error",name);
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session,Model model) {
        session.invalidate();
        return list(model);
    }
}
