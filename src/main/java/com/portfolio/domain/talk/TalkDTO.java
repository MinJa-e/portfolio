package com.portfolio.domain.talk;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TalkDTO {

    private int talkNum;
    private String nickname;
    private String talkContent;
    private LocalDateTime date;
    private Boolean talkLock;
    private String id;

}
