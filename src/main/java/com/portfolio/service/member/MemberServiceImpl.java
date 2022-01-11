package com.portfolio.service.member;


import com.portfolio.domain.member.MemberDTO;
import com.portfolio.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;

    @Override
    public void join(MemberDTO memberDTO) {
        memberMapper.join(memberDTO);
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