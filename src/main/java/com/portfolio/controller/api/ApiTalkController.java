package com.portfolio.controller.api;

import com.portfolio.domain.talk.TalkDTO;
import com.portfolio.service.talk.TalkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{talkNum}")
    public TalkDTO get(@PathVariable int talkNum) {
        return talkService.get(talkNum);
    }

    @PutMapping("/{talkNum}")
    public void update(TalkDTO talkDTO) {
        talkService.update(talkDTO);
    }

    @GetMapping("/delete/{talkNum}")
    public String delete(@PathVariable int talkNum) {
        talkService.delete(talkNum);
        return "redirect:/talk";
    }

}
