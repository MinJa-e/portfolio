package com.portfolio.service.talk;


import com.portfolio.domain.talk.TalkDTO;
import com.portfolio.mapper.talk.TalkMapper;
import com.portfolio.pagination.PaginationInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TalkServiceImpl implements TalkService {

    private final TalkMapper talkMapper;


    @Override
    public void create(TalkDTO talkDTO) {
        talkMapper.insert(talkDTO);

    }

    @Override
    public List<TalkDTO> getList(TalkDTO talkDTO) {
        List<TalkDTO> talkList = Collections.emptyList();

        int boardTotalCount = talkMapper.getTalkTotalCount(talkDTO);

        PaginationInfo paginationInfo = new PaginationInfo(talkDTO);
        paginationInfo.setTotalRecordCount(boardTotalCount);

        talkDTO.setPaginationInfo(paginationInfo);

        if (boardTotalCount > 0) {
            talkList = talkMapper.getList(talkDTO);
        }

        return talkList;
    }

    @Override
    public TalkDTO get(int talkNum) {
        return talkMapper.get(talkNum);
    }

    @Override
    public void update(TalkDTO talkDTO) {
        talkMapper.update(talkDTO);
    }

    @Override
    public void delete(int talkNum) {
        talkMapper.delete(talkNum);
    }

}