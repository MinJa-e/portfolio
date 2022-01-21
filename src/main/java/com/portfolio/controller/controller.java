package com.portfolio.controller;

import com.portfolio.domain.talk.TalkDTO;
import com.portfolio.pagination.Criteria;
import com.portfolio.pagination.PageMaker;
import com.portfolio.service.talk.TalkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class controller {

    private final TalkService talkService;

    @GetMapping
    public String index(){
        return "index";
    }

    @GetMapping("/portfolio")
    public String portfolio(){
        return "views/portfolio";
    }

    @GetMapping("talk")
    public String talkList(Criteria criteria, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.getAttribute("login");
        if(session.getAttribute("login") == null){
            return "redirect:/";
        }

        PageMaker pageMaker = new PageMaker();
        pageMaker.setCri(criteria);
        pageMaker.setTotalCount(talkService.countTalkList());//총게시글수 조횐데 아직 로직 구현x여서 임의로 넣음

        List<TalkDTO> List = talkService.getList(criteria);

        model.addAttribute("list",talkService.getList(criteria));
        model.addAttribute("pageMaker", pageMaker);

        return "views/talk";
    }

    @GetMapping("warning")
    public String warning(){
        return "views/warning";
    }

    @GetMapping("detailPage/triplan")
    public String detailPagetriplan(){
        return "views/detailPage/triplan";
    }

    @GetMapping("detailPage/portfolio")
    public String detailPagePortfolio(){
        return "views/detailPage/portfolio";
    }
}
