package com.example.test.service;

import com.example.test.domain.Member;
import com.example.test.repository.MemberRepository;
import com.example.test.repository.MemoryMemberRepository;
import org.junit.jupiter.api.*;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //given 주어져서 데이터 기반
        Member member = new Member();
        member.setName("hello");

        //when 실행했는데 이걸 검증
        Long saveId = memberService.join(member);

        //then 결과가 이래나옴 검증부
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class,() -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try{
//            memberService.join(member2);
//            fail();
//        }catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
        //then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}