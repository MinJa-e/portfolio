package com.portfolio.mapper.member;

import com.portfolio.domain.member.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    void join(MemberDTO memberDTO);

    MemberDTO login(MemberDTO memberDTO);

    MemberDTO getMember(MemberDTO memberDTO);

    Boolean idCheck(String id);

    Boolean nicknameCheck(String nickname);

    void updateNickname(MemberDTO memberDTO);

    void updatePwd(MemberDTO memberDTO);
}