package com.portfolio.domain.talk;

import com.portfolio.domain.CommonDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TalkDTO extends CommonDTO {

    private int talkNum;
    private String nickname;
    private String talkContent;
    private LocalDateTime date;
    private Boolean talkLock;


}
