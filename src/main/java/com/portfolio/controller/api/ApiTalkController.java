package com.portfolio.controller.api;

import com.portfolio.domain.member.MemberDTO;
import com.portfolio.domain.talk.TalkDTO;
import com.portfolio.service.talk.TalkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/talks")
@RequiredArgsConstructor
public class ApiTalkController {

    private final TalkService talkService;

    @PostMapping
    public String create(TalkDTO talkDTO) {
        talkService.create(talkDTO);
        return "redirect:/talk";
    }

}
