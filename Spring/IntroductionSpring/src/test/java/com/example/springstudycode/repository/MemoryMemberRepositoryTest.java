package com.example.springstudycode.repository;

import com.example.springstudycode.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        //내가 repository에 넣은 값이 제대로 들어갔는지 확인
        Member result = repository.findById(member.getId()).get();
        //검증
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        Assertions.assertThat(result).isEqualTo(member1);
    }
}
