package com.portfolio.repository;

import com.portfolio.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByNo(Long no);
    Optional<Member> findByNickname(String nickname);
    List<Member> findAll();

}
