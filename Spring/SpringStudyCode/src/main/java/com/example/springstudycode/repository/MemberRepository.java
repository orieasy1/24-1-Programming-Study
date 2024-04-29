package com.example.springstudycode.repository;

import com.example.springstudycode.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //요즘은 null을 반환할 떄 Optional로 감싸서 반환하는 것을 선호
    Optional<Member> findByname(String name);
    List<Member> findAll();

}
