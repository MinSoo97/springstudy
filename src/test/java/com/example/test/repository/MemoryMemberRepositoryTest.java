package com.example.test.repository;

import com.example.test.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
//test를 해야하는 이유 << 혼자하면 상관없는데 다같이 다양한 것을 하다보면 꼭 필요함
public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){  //각 테스트가 끝난후에 저장소나 공용 데이터를 지워준다.
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member,result);  //기대값, 결과 같으면 실행이 되지만 다르면 실패가 뜬다.
        assertThat(member).isEqualTo(result); // 같은 방법이지만 쫌더 간단하게 쓸 수 있음 멤버가 result랑 똑같다. 라는 뜻
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring");

        repository.save(member1);

        Member result =  repository.findByName("spring1").get();

        assertThat(member1).isEqualTo(result);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}
