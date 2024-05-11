package com.example.springstudycode.repository;

import com.example.springstudycode.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    //동시성 문제 고려안함(실무에서는 고려 필수)
    private static Map<Long, Member> store = new HashMap<>();   //저장소
    private static long sequence =0L;   //키값을 생성

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //null이 반환될 가능성이 있으면 Optional.ofNullable()을 감싸서 반환
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

}
