package com.portfolio.mapper.talk;

import com.portfolio.domain.member.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TalkMapper {

    void insert();
}