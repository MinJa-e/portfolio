package com.portfolio.mapper.member;

import com.portfolio.domain.member.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    void join(MemberDTO memberDTO);
    String login(String id);
}