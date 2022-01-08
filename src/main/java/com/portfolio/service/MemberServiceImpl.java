package com.portfolio.service;


import com.portfolio.domain.MemberDTO;
import com.portfolio.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;

    @Override
    public void join(MemberDTO memberDTO) {
        memberMapper.insert(memberDTO);
    }

    @Override
    public void login(String id, String password) {
            if(memberMapper.login(id) == password){
                System.out.println("로그인 성공");
            }
    }


}