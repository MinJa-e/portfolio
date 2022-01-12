package com.portfolio.mapper.talk;

import com.portfolio.domain.talk.TalkDTO;
import com.portfolio.pagination.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TalkMapper {

    void insert(TalkDTO talkDTO);

    List<TalkDTO> getList(Criteria criteria);

    TalkDTO get(int talkNum);

    void update(TalkDTO talkDTO);

    void delete(int talkNum);

}