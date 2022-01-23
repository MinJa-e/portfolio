package com.portfolio.controller.api;

import com.portfolio.domain.member.MemberDTO;
import com.portfolio.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    public Boolean login(@RequestBody MemberDTO memberDTO, HttpServletRequest request) { // 포스트로 전달할 땐 RequestBOdy로 받아야
                                                                                         // 함
        HttpSession session = request.getSession();
        System.out.println(memberService.login(memberDTO));
        memberService.login(memberDTO);
        if (memberService.login(memberDTO) != null) {// true일떄
            System.out.println(memberService.login(memberDTO));
            session.setAttribute("login", memberService.login(memberDTO));
            return true;
        } else {
            System.out.println("컨트롤러-로그인 실패");
        }
        ;
        return false;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }

    @PatchMapping("/nickname")
    public void updateNickname(@RequestBody MemberDTO memberDTO, HttpServletRequest request) {
        HttpSession session = request.getSession();
        memberService.updateNickname(memberDTO);
        System.out.println(memberDTO);
        session.setAttribute("login", memberService.getMember(memberDTO));
    }

    @PatchMapping("/pwd")
    public void updatePwd(@RequestBody MemberDTO memberDTO, HttpServletRequest request) {
        HttpSession session = request.getSession();
        memberService.updatePwd(memberDTO);
        System.out.println(memberDTO);
        session.setAttribute("login", memberService.getMember(memberDTO));
    }

    @GetMapping("/idCheck")
    @ResponseBody
    public boolean idCheck(String id) {
        System.out.println("서비스 실행시 콘솔");
        System.out.println(memberService.idCheck(id));
        if (memberService.idCheck(id) != null) {
            System.out.println("컨트롤러-아디 중복");
            return false;
        } else {
            System.out.println("컨트롤러-아디 사용가능");
            return true;
        }
    }

    @GetMapping("/nicknameCheck")
    @ResponseBody
    public boolean nicknameCheck(String nickname) {
        System.out.println("서비스 실행시 콘솔");
        System.out.println(memberService.nicknameCheck(nickname));
        if (memberService.nicknameCheck(nickname) != null) {
            System.out.println("컨트롤러-닉넴 중복");
            return false;
        } else {
            System.out.println("컨트롤러-닉넴 사용가능");
            return true;
        }
    }

}
