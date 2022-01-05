package com.portfolio.service;

import com.portfolio.domain.Member;
import com.portfolio.repository.MemberRepository;
import com.portfolio.repository.MemoryMemberRepository;

import java.util.Optional;

public class MemberService {

    private  final MemberRepository memberRepository = new MemoryMemberRepository();

    public Long join(Member member){
        Optional<Member> result = memberRepository.findByNickname(member.getNickname());
        result.ifPresent(member1 -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });

        memberRepository.save(member);
        return member.getNo();
    }
}
