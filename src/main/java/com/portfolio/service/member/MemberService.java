package com.portfolio.service.member;

import com.portfolio.domain.member.MemberDTO;

public interface MemberService {//여기 매개변수가 있어야 거기 담겨서 맵퍼로 옮겨짐

    void join(MemberDTO memberDTO);

    MemberDTO login(MemberDTO memberDTO);

    MemberDTO getMember(MemberDTO memberDTO);

    void updateNickname(MemberDTO memberDTO);

    void updatePwd(MemberDTO memberDTO);

}