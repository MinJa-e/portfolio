package com.portfolio.service.member;

import com.portfolio.domain.member.MemberDTO;

public interface MemberService {

    void join(MemberDTO memberDTO);
    Boolean login(String id, String password);

}