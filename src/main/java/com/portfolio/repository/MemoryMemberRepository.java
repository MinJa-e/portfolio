package com.portfolio.repository;

import com.portfolio.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setNo(++sequence);
        store.put(member.getNo(), member);
        return member;
    }

    @Override
    public Optional<Member> findByNo(Long no) {
        return Optional.ofNullable(store.get(no));
    }

    @Override
    public Optional<Member> findByNickname(String nickname) {

        return store.values().stream().filter(member -> member.getNickname().equals(nickname)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

}
