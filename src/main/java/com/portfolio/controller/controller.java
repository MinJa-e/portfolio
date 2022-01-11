package com.portfolio.controller;

import com.portfolio.service.talk.TalkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String talkList(Model model) {

        model.addAttribute("list",talkService.getList());

        return "views/talk";
    }

    @GetMapping("warning")
    public String warning(){
        return "views/warning";
    }
}
