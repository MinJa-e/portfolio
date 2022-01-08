package com.portfolio.service;

import com.portfolio.domain.MemberDTO;

import javax.servlet.http.HttpServletRequest;

public interface MemberService {

    void join(MemberDTO memberDTO);
    Boolean login(String id, String password);

}