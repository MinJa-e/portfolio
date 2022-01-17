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
    public MemberDTO login(MemberDTO memberDTO) {
            return memberMapper.login(memberDTO);

    }

    @Override
    public MemberDTO getMember(MemberDTO memberDTO) {
        return memberMapper.getMember(memberDTO);
    }

    @Override
    public Boolean idCheck(String id) {
        return memberMapper.idCheck(id);
    }

    @Override
    public Boolean nicknameCheck(String nickname) {
        return memberMapper.nicknameCheck(nickname);
    }

    @Override
    public void updateNickname(MemberDTO memberDTO) {
        memberMapper.updateNickname(memberDTO);
    }

    @Override
    public void updatePwd(MemberDTO memberDTO) {
        memberMapper.updatePwd(memberDTO);
    }


}