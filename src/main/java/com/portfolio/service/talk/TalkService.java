package com.portfolio.service.talk;

import com.portfolio.domain.talk.TalkDTO;
import com.portfolio.pagination.Criteria;

import java.util.List;

public interface TalkService {

    void create(TalkDTO talkDTO);

    List<TalkDTO> getList(Criteria criteria);

    int countTalkList();

    TalkDTO get(int talkNum);

    void update(TalkDTO talkDTO);

    void delete(int talkNum);

}