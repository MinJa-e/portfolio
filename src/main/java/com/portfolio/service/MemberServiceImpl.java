package com.portfolio.service;


import com.portfolio.domain.MemberDTO;
import com.portfolio.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;

    @Override
    public void join(MemberDTO memberDTO) {
        memberMapper.insert(memberDTO);
    }

    @Override
    public Boolean login(String id, String password) {
        System.out.println(memberMapper.login(id));
        System.out.println(password);
            if( memberMapper.login(id).equals(password) ){
                System.out.println("로그인 성공");
                return true;
            }else{
            System.out.println("로그인 실패");
            return false;
        }
    }


}