package com.portfolio.controller;

import com.portfolio.domain.talk.TalkDTO;
import com.portfolio.service.talk.TalkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class controller {

    private final TalkService talkService;

    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("portfolio")
    public String portfolio(){
        return "views/portfolio";
    }

    @GetMapping("talk")
    public String talkList(@ModelAttribute("talkDTO") TalkDTO talkDTO, Model model) {
        List<TalkDTO> talkList = talkService.getList(talkDTO);

        model.addAttribute("list",talkService.getList(talkDTO));

        return "views/talk";
    }

    @GetMapping("warning")
    public String warning(){
        return "views/warning";
    }
}
