package com.example.ass2.Person.controller;

import com.example.ass2.Person.dto.MemberDto;
import com.example.ass2.Person.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class MemberController {

    private MemberService memberService;

    @GetMapping("user/signup")
    public String signUpForm(){
        return "users/signup.html";
    }

    @PostMapping("user/signup")
    public String signUp(MemberDto memberDto){
        memberService.joinUser(memberDto);

        return "redirect:/";
    }

    @GetMapping("user/login")
    public String member(){
        return "users/login.html";
    }

    @GetMapping("user/admin")
    public String admin(Model model) {
        List<MemberDto> memberDtoList = memberService.getMemberlist();
        model.addAttribute("memberList", memberDtoList);

        return "users/admin.html";
    }

}
