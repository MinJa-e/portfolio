package com.portfolio.mapper.member;

import com.portfolio.domain.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    void insert(MemberDTO memberDTO);
    String login(String id);
}