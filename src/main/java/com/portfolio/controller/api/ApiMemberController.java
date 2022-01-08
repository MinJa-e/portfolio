package com.portfolio.controller.api;

import com.portfolio.domain.MemberDTO;
import com.portfolio.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String login(String id, String password) {
        memberService.login(id, password);
        return "redirect:/";
    }

}
