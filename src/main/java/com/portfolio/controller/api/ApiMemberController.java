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

    @PostMapping
    public String join(MemberDTO memberDTO) {
        memberService.join(memberDTO);
        return "index";
    }

}
