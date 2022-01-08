package com.portfolio.controller.api;

import com.portfolio.domain.MemberDTO;
import com.portfolio.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class ApiMemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public String join(MemberDTO memberDTO) {
        memberService.join(memberDTO);
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(String id, String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(memberService.login(id, password)){//true일떄
            session.setAttribute("login", id);
            System.out.println("컨트롤러-로그인 성공");
        }else{
            System.out.println("컨트롤러-로그인 실패");
        };
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }

}
