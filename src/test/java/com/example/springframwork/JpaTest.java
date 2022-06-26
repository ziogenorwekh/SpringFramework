package com.example.springframwork;


import com.example.springframwork.dao.Member;
import com.example.springframwork.dao.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
//@DataJpaTest
@Transactional
@SpringBootTest
public class JpaTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void JPA테스트() {
        Member member = new Member();
        member.setName("안녕하세요2");
        member.setEmail("이메일@이메일.com");


        memberRepository.save(member);


        Member member1 = memberRepository.findMemberByName("안녕하세요2");

        assertThat(member).isNotNull();
        assertThat(member).isEqualTo(member1);
    }
    @Test
    public void JPA테스트2() {
        Member member = new Member();
        member.setName("Test");
        member.setEmail("T@T.com");
        Member member1 = new Member();
        member1.setName("Test2");
        Member member2 = new Member();
        member2.setName("Test3");


        memberRepository.save(member);

        memberRepository.save(member1);

        memberRepository.save(member2);

        long count = memberRepository.count();

        assertThat(count).isEqualTo(3L);

        List<Member> memberList = memberRepository.findAll();

        for (Member member3 : memberList) {
            System.out.println("member3 = " + member3);
        }
    }
}
