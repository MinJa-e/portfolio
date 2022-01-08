package com.portfolio.service;

import com.portfolio.domain.MemberDTO;

public interface MemberService {

    void join(MemberDTO memberDTO);
    void login(String id, String password);

}