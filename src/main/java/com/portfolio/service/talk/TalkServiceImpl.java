package com.portfolio.service.talk;


import com.portfolio.domain.talk.TalkDTO;
import com.portfolio.mapper.talk.TalkMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TalkServiceImpl implements TalkService {

    private final TalkMapper talkMapper;


    @Override
    public void create(TalkDTO talkDTO) {
        talkMapper.insert();

    }
}