package com.portfolio.controller.api;

import com.portfolio.domain.member.MemberDTO;
import com.portfolio.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String login(MemberDTO memberDTO, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        memberService.login(memberDTO);
        if(memberService.login(memberDTO) != null){//true일떄
            System.out.println(memberService.login(memberDTO));
            session.setAttribute("login", memberService.login(memberDTO));
        }else{
            model.addAttribute("warning", "아이디 혹은 비밀번호가 일치하지 않습니다.");
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

    @GetMapping("/update/nickname")
    public String updateNickname(MemberDTO memberDTO,HttpServletRequest request) {
        HttpSession session = request.getSession();
        memberService.updateNickname(memberDTO);
        session.setAttribute("login",memberService.getMember(memberDTO));
        return "redirect:/";
    }

    @GetMapping("/update/pwd")
    public String updatePwd(MemberDTO memberDTO,HttpServletRequest request) {
        HttpSession session = request.getSession();
        memberService.updatePwd(memberDTO);
        session.setAttribute("login",memberService.getMember(memberDTO));
        return "redirect:/";
    }

}
